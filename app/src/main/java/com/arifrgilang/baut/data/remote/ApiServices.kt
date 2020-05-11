/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:20 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:20 AM
 *
 */

package com.arifrgilang.baut.data.remote

import com.arifrgilang.baut.data.model.ArrayResponse
import com.arifrgilang.baut.data.model.CharacterModel
import io.reactivex.Single
import retrofit2.http.*

interface ApiServices {
    @GET("character")
    fun getAllCharacter() : Single<ArrayResponse<CharacterModel>>

    @GET("character/{id}")
    fun getCharacter(
        @Path("id") id: Int
    ): Single<CharacterModel>
}