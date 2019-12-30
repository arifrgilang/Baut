/*
 * *
 *  * Created by Arif R. Gilang on 12/30/19 3:24 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/30/19 3:24 PM
 *
 */

package com.arifrgilang.baut.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

// THIS IS EXAMPLE OF MODEL FOR ROOM USAGE, MODEL WITH SUB MODEL INSIDE
@Entity
data class CharacterModel(
    @ColumnInfo(name = "id") //Room Collumn Name
    @SerializedName("id") // Remote JSON Key / Object Name
    val id: Int?,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String?,

    @ColumnInfo(name = "status")
    @SerializedName("status")
    val status: String?,

    @ColumnInfo(name = "type")
    @SerializedName("type")
    val type: String?,

    @ColumnInfo(name = "gender")
    @SerializedName("gender")
    val gender: String?,

    @Embedded(prefix = "origin")
    @SerializedName("origin")
    val origin: OriginModel?,

    @Embedded(prefix = "location")
    @SerializedName("location")
    val location: LocationModel?,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    val image: String?,

    @ColumnInfo(name = "episode")
    @SerializedName("episode")
    val episode: List<String>?,

    @ColumnInfo(name = "url")
    @SerializedName("url")
    val url: String?,

    @ColumnInfo(name = "created")
    @SerializedName("created")
    val created: String?
)

data class OriginModel (
    @ColumnInfo(name = "origin_name")
    @SerializedName("name")
    val originName: String?,

    @ColumnInfo(name = "origin_url")
    @SerializedName("url")
    val originUrl: String?
)

data class LocationModel (
    @ColumnInfo(name = "location_name")
    @SerializedName("name")
    val locationName: String?,

    @ColumnInfo(name = "location_url")
    @SerializedName("url")
    val locationUrl: String?
)