package com.nicos.ships.data.room_database.ships.dao

import androidx.room.Dao
import androidx.room.Query
import com.nicos.ships.data.room_database.init_database.BaseDao
import com.nicos.ships.data.room_database.ships.PositionEntity

@Dao
interface PositionDao: BaseDao<PositionEntity, MutableList<PositionEntity>> {

    @Query("SELECT * FROM positionmodel WHERE positionId=:id")
    suspend fun getPositionById(id: Long): PositionEntity?

    @Query("DELETE FROM PositionEntity")
    suspend fun deleteAll()
}