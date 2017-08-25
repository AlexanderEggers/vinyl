package de.acando.vinyl.api

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.google.gson.GsonBuilder
import de.acando.vinyl.AppExecutor
import de.acando.vinyl.model.Article
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.util.ArrayList
import javax.inject.Inject

class ArticleAPIController @Inject constructor(private val appExecutor: AppExecutor) {

    private var listResult : MutableLiveData<List<Article>> = MutableLiveData()

    fun loadAll(context: Context) : LiveData<List<Article>> {
        appExecutor.diskIO().execute({
            internalLoadAll(context)
        })

        return listResult
    }

    private fun internalLoadAll(context: Context) {
        val input : InputStream = context.assets.open("articles.json")
        val size = input.available()
        val buffer = ByteArray(size)

        input.read(buffer)
        input.close()

        val gson = GsonBuilder().create()

        val json = JSONObject(String(buffer))
        val jsonArray : JSONArray = json.getJSONArray("articles")

        val list = ArrayList<Article>()
        for (i in 0 until jsonArray.length()) {
            list.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), Article::class.java))
        }

        listResult.value = list
    }
}