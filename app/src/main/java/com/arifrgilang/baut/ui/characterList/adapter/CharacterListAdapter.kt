/*
 * *
 *  * Created by Arif R. Gilang on 12/30/19 3:59 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/30/19 3:59 PM
 *
 */

package com.arifrgilang.baut.ui.characterList.adapter

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import com.arifrgilang.baut.R
import com.arifrgilang.baut.base.BaseRecyclerAdapter
import com.arifrgilang.baut.data.model.CharacterModel
import com.arifrgilang.baut.databinding.ItemCharacterBinding
import org.jetbrains.anko.sdk27.coroutines.onClick

class CharacterListAdapter(
    context: Context?,
    list: MutableList<CharacterModel>
) : BaseRecyclerAdapter<CharacterModel, ItemCharacterBinding, CharacterListAdapter.ViewHolder>(context, list) {

    override fun getResLayout(type: Int): Int = R.layout.item_character

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(initViewBinding(viewType, parent))

    inner class ViewHolder(view: ItemCharacterBinding): BaseViewHolder(view) {
        override fun onBind(model: CharacterModel) {
            Log.d("ViewHolderModel", "model : $model")
            view.data = model
            view.rlItemCharacter.onClick {
                context?.let{
                    //                    val intent = Intent(context, WorkshopDetailActivity::class.java)
                    //                    intent.putExtra(WorkshopDetailActivity.WORKSHOP_ID, model.idWorkshop)
                    //                    it.startActivity(intent)
                }
            }
        }
    }
}