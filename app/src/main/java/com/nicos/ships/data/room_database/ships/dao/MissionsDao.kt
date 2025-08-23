package com.nicos.ships.data.room_database.ships.dao

import androidx.room.Dao
import androidx.room.Query
import com.nicos.ships.data.room_database.init_database.BaseDao
import com.nicos.ships.data.room_database.ships.MissionsEntity

@Dao
interface MissionsDao : BaseDao<MissionsEntity, MutableList<MissionsEntity>> {

    @Query("SELECT * FROM MissionsEntity WHERE shipId=:id")
    suspend fun getAllMissionsByShipId(id: String): MutableList<MissionsEntity>

    @Query("SELECT * FROM MissionsEntity")
    suspend fun getAllMissions(): MutableList<MissionsEntity>

    @Query("DELETE FROM missionsmodel")
    suspend fun deleteAll()
}