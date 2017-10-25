package de.acando.vinyl.ui.genre

import android.os.Bundle
import android.support.v4.app.Fragment

class GenreFragment : Fragment() {

    private val KEY_ITEM_ID = "itemID"

    fun forItem(id : Int) : GenreFragment {
        val fragment = GenreFragment()
        val args = Bundle()
        args.putInt(KEY_ITEM_ID, id)
        fragment.arguments = args
        return fragment
    }
}