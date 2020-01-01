/*
 * *
 *  * Created by Arif R. Gilang on 12/30/19 3:49 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/30/19 3:48 PM
 *
 */

package com.arifrgilang.baut.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ArrayResponse<Model>(
    var info: InfoModel? = null,
    var results: List<Model>? = null
)

data class InfoModel(
    var count: Int?,
    var pages: Int?,
    var next: String?,
    var prev: String?
) : Serializable
