/*
 * *
 *  * Created by Arif R. Gilang on 12/30/19 3:59 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/30/19 3:58 PM
 *
 */

package com.arifrgilang.baut.ui.characterList.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.arifrgilang.baut.R
import com.arifrgilang.baut.base.BaseActivity
import com.arifrgilang.baut.data.model.CharacterModel
import com.arifrgilang.baut.ui.characterList.adapter.CharacterListAdapter
import com.arifrgilang.baut.ui.characterList.viewModel.CharacterListViewModel
import com.arifrgilang.baut.utils.AppUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.support.v4.onRefresh

class CharacterListActivity : BaseActivity() {
    private lateinit var viewModel: CharacterListViewModel
    private lateinit var rvAdapter: CharacterListAdapter
    private lateinit var list: ArrayList<CharacterModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(CharacterListViewModel::class.java)
        setRecyclerView()
        viewModel.refresh()
        observeViewModel()
        srCharacterList.onRefresh { viewModel.refreshBypassCache() }
    }

    private fun setRecyclerView() {
        list = arrayListOf()
        rvAdapter = CharacterListAdapter(this, list)
        rvCharacterList.adapter = rvAdapter
        rvCharacterList.layoutManager = AppUtils.gridLayoutManager(this, 2)
    }

    private fun observeViewModel() {
        viewModel.list.observe(this, Observer {
            it?.let {
                list.clear()
                list.addAll(it)

                rvAdapter.clearAndNotify()
                rvAdapter.insertAndNotify(it)
                srCharacterList.isRefreshing = false
            }
        })

        viewModel.isLoading.observe(this, Observer {
            srCharacterList.isRefreshing = it
        })

        viewModel.isError.observe(this, Observer {
            list.clear()
            rvAdapter.clearAndNotify()

            tvError.visibility = if(it) View.VISIBLE else View.GONE
            rvCharacterList.visibility = if(it) View.GONE else View.VISIBLE
        })
    }
}
