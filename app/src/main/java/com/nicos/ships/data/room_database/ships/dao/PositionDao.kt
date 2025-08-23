package com.nicos.ships.data.room_database.ships.dao

import androidx.room.Dao
import androidx.room.Query
import com.nicos.ships.data.room_database.init_database.BaseDao
import com.nicos.ships.data.room_database.ships.PositionModel

@Dao
interface PositionDao: BaseDao<PositionModel, MutableList<PositionModel>> {

    @Query("SELECT * FROM positionmodel WHERE positionId=:id")
    suspend fun getPositionById(id: Long): PositionModel?

    @Query("DELETE FROM PositionModel")
    suspend fun deleteAll()
}