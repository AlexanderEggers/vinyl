package de.acando.vinyl.api

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.google.gson.GsonBuilder
import de.acando.vinyl.AppExecutor
import de.acando.vinyl.model.Genre
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.util.ArrayList
import javax.inject.Inject

class GenreAPIController @Inject constructor(private val appExecutor: AppExecutor) {

    private var listResult : MutableLiveData<List<Genre>> = MutableLiveData()

    fun loadAll(context: Context) : LiveData<List<Genre>> {
        appExecutor.diskIO().execute({
            internalLoadAll(context)
        })

        return listResult
    }

    private fun internalLoadAll(context: Context) {
        val input : InputStream = context.assets.open("genres.json")
        val size = input.available()
        val buffer = ByteArray(size)

        input.read(buffer)
        input.close()

        val gson = GsonBuilder().create()

        val json = JSONObject(String(buffer))
        val jsonArray : JSONArray = json.getJSONArray("genres")

        val list = ArrayList<Genre>()
        for (i in 0 until jsonArray.length()) {
            list.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), Genre::class.java))
        }

        listResult.value = list
    }
}