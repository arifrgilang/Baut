/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:17 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:17 AM
 *
 */

package com.arifrgilang.baut.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(contentView(), container, false)
        setupData(savedInstanceState)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    protected abstract fun contentView(): Int
    protected abstract fun setupData(savedInstanceState: Bundle?)
    protected abstract fun setupView()
}