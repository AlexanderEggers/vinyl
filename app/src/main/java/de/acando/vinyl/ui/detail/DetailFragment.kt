package de.acando.vinyl.ui.detail

import android.os.Bundle
import android.support.v4.app.Fragment

class DetailFragment : Fragment() {

    private val KEY_ITEM_ID = "itemID"

    fun forItem(id : Int) : DetailFragment {
        val fragment = DetailFragment()
        val args = Bundle()
        args.putInt(KEY_ITEM_ID, id)
        fragment.arguments = args
        return fragment
    }
}