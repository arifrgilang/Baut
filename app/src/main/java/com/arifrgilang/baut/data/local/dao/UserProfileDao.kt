/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:29 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:29 AM
 *
 */

package com.arifrgilang.baut.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.arifrgilang.baut.data.model.UserProfileModel

// THIS IS DAO EXAMPLE
@Dao
interface UserProfileDao {
//    @Insert
//    suspend fun insertUser(vararg user: UserProfileModel)
//
//    @Query("SELECT * FROM userprofilemodel WHERE uuid = :userId")
//    suspend fun getUser(userId: Int): UserProfileModel // dogId is primary key
//
//    @Query("DELETE FROM userprofilemodel")
//    suspend fun deleteAllUser()
}