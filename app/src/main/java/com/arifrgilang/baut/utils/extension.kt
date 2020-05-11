/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:35 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:35 AM
 *
 */

package com.arifrgilang.baut.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.arifrgilang.baut.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable){
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .centerCrop()
        .error(R.mipmap.ic_launcher)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}

fun ImageView.circleDrawable(drawable: Drawable?){
    val options = RequestOptions()
        .error(R.mipmap.ic_launcher)
        .circleCrop()
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(drawable)
        .into(this)
}

fun ImageView.loadBitmap(bitmap: Bitmap?){
    val options = RequestOptions()
        .error(R.mipmap.ic_launcher)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(bitmap)
        .into(this)
}

fun ImageView.loadPath(path: String){
    val options = RequestOptions()
        .error(R.mipmap.ic_launcher)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(path)
        .into(this)
}

//Crete Name Space for XML
@BindingAdapter("android:imageUrl")
fun loadImage(view: ImageView, url: String?){
    view.loadImage(url, getProgressDrawable(view.context))
}
