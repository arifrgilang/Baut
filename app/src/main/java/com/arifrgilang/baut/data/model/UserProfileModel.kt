/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:28 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:28 AM
 *
 */

package com.arifrgilang.baut.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

// THIS IS EXAMPLE OF MODEL FOR ROOM USAGE, MODEL WITH SUB MODEL INSIDE
@Entity
data class UserProfileModel (
    @ColumnInfo(name = "user_id")
    @SerializedName("id")
    val id: String?,

    @ColumnInfo(name = "user_name") //Room Collumn Name
    @SerializedName("user_name") // Remote JSON Key / Object Name
    val userName: String?,

    @Embedded(prefix = "job")
    @SerializedName("job")
    val job: ArrayList<JobModel>?,

    @ColumnInfo(name = "user_phone")
    @SerializedName("user_phone")
    val phoneNumber: String?,

    @ColumnInfo(name = "user_nik")
    @SerializedName("nik")
    val nik: String?,

    @ColumnInfo(name = "user_address")
    @SerializedName("address")
    val address: String?,

    @ColumnInfo(name = "user_verificated")
    @SerializedName("verificated")
    val verificated: String?,

    @ColumnInfo(name = "url_photo")
    @SerializedName("url_photo")
    val urlPhoto: String?,

    @ColumnInfo(name = "link_bio")
    @SerializedName("link_bio")
    val linkBio: String?,

    @Embedded(prefix = "city")
    @SerializedName("city")
    val city: ArrayList<CityModel>,

    @Embedded(prefix = "brand")
    @SerializedName("brand")
    val brand: ArrayList<BrandModel>,

    @ColumnInfo(name = "created_at_time")
    @SerializedName("created_at_time")
    val createdAt: String?,

    @ColumnInfo(name = "updated_at_time")
    @SerializedName("updated_at_time")
    val updatedAt: String?

){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}

data class JobModel(
    @ColumnInfo(name = "job_id")
    @SerializedName("job_id")
    val id: String?,

    @ColumnInfo(name = "name_job")
    @SerializedName("name_job")
    val jobName: String?
)

data class CityModel(
    @ColumnInfo(name = "id_city")
    @SerializedName("id_city")
    val id: String?,

    @ColumnInfo(name = "name_city")
    @SerializedName("name_city")
    val cityName: String?
)

data class BrandModel(
    @ColumnInfo(name = "brand_name")
    @SerializedName("brand_name")
    val brandName: String,

    @ColumnInfo(name = "id_brand_city")
    @SerializedName("id_brand_city")
    val idBrandCity: String?,

    @ColumnInfo(name = "brand_city")
    @SerializedName("brand_city")
    val brandCity: String?
)