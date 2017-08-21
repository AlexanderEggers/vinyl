package de.acando.vinyl.ui.genre

import android.arch.lifecycle.LifecycleFragment
import android.os.Bundle

class GenreFragment : LifecycleFragment() {

    private val KEY_ITEM_ID = "itemID"

    fun forItem(id : Int) : GenreFragment {
        val fragment = GenreFragment()
        val args = Bundle()
        args.putInt(KEY_ITEM_ID, id)
        fragment.arguments = args
        return fragment
    }
}