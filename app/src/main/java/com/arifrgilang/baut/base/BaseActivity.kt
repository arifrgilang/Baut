/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:12 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:12 AM
 *
 */

package com.arifrgilang.baut.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity(){

    var isActive = false
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isActive = true
    }

    override fun onDestroy() {
        isActive = false
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar(isHasBackButton: Boolean) {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setHomeButtonEnabled(isHasBackButton)
            supportActionBar!!.setDisplayHomeAsUpEnabled(isHasBackButton)
            toolbar!!.setNavigationOnClickListener { onBackPressed() }
        }
    }

    protected fun setupToolbar(title: String, isHasBackButton: Boolean) {
        setupToolbar(isHasBackButton)
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }
}