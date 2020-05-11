/*
 * *
 *  * Created by Arif R. Gilang on 12/30/19 3:35 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/30/19 3:35 PM
 *
 */

package com.arifrgilang.baut.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.arifrgilang.baut.data.model.CharacterModel

@Dao
interface CharacterModelDao {
    @Insert
    suspend fun insertAll(characters: List<CharacterModel>)

    @Query("SELECT * FROM charactermodel")
    suspend fun getAllCharacter() : List<CharacterModel>

    @Query("DELETE FROM charactermodel")
    suspend fun deleteAllCharacter()

    // ANOTHER EXAMPLE WITH PARAMETER
    //    @Query("SELECT * FROM charactermodel WHERE id = :id")
//    suspend fun getCharacter(id: Int): CharacterModel
}