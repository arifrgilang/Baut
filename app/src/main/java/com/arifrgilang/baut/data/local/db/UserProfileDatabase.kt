/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:30 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:30 AM
 *
 */

package com.arifrgilang.baut.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arifrgilang.baut.data.local.dao.UserProfileDao
import com.arifrgilang.baut.data.model.UserProfileModel

// THIS IS DB EXAMPLE
@Database(entities = arrayOf(UserProfileModel::class), version = 1) // it means we can only have UserProfile class data
abstract class UserProfileDatabase: RoomDatabase() { // this is singleton
//    abstract fun userDao(): UserProfileDao
//
//    companion object {
//        @Volatile private var instance: UserProfileDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
//            instance ?: buildDatabase(context).also {
//                instance = it
//            }
//        }
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            UserProfileDatabase::class.java,
//            "userdatabase"
//        ).build()
//    }
}