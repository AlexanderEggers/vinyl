package com.acando.vinyl.ui.detail

import android.arch.lifecycle.LifecycleFragment
import android.os.Bundle

class DetailFragment : LifecycleFragment() {

    private val KEY_ITEM_ID = "itemID"

    fun forItem(id : Int) : DetailFragment {
        val fragment = DetailFragment()
        val args = Bundle()
        args.putInt(KEY_ITEM_ID, id)
        fragment.arguments = args
        return fragment
    }
}