package com.nicos.ships.data.room_database.ships.dao

import androidx.room.Dao
import androidx.room.Query
import com.nicos.ships.data.room_database.init_database.BaseDao
import com.nicos.ships.data.room_database.ships.MissionsModel

@Dao
interface MissionsDao : BaseDao<MissionsModel, MutableList<MissionsModel>> {

    @Query("SELECT * FROM MissionsModel WHERE shipId=:id")
    suspend fun getAllMissionsByShipId(id: String): MutableList<MissionsModel>

    @Query("SELECT * FROM MissionsModel")
    suspend fun getAllMissions(): MutableList<MissionsModel>

    @Query("DELETE FROM missionsmodel")
    suspend fun deleteAll()
}