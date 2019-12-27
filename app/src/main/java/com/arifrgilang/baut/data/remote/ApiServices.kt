/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:20 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:20 AM
 *
 */

package com.arifrgilang.baut.data.remote

import io.reactivex.Single
import retrofit2.http.*

interface ApiServices {

//    @GET("/user/exist")
//    fun isUserExist(
//        @Query("phone_number") phoneNumber : String
//    ) : Single<ResponseObject<UserExistModel>>
//
//    @POST("/user/register")
//    @FormUrlEncoded
//    fun registerUser(
//        @Field("idToken") idToken: String,
//        @Field("name") name: String,
//        @Field("id_job") idJob: Int,
//        @Field("id_user_city") idUserCity: Int
//    ) : Single<ResponseObject<AccessTokenModel>>
//
//    @POST("/user/register")
//    @FormUrlEncoded
//    fun loginUser(
//        @Field("idToken") idToken: String
//    ) : Single<ResponseObject<AccessTokenModel>>
//
//    @GET("user/profile/{id}")
//    fun getProfile(
//        @Path("id") id: Int
//    ): Single<ResponseObject<UserProfileModel>>
}