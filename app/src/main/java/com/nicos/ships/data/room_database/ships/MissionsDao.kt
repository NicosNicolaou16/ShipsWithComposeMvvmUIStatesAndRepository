package com.nicos.ships.data.room_database.ships

import androidx.room.Dao
import androidx.room.Query
import com.nicos.ships.data.room_database.init_database.BaseDao

@Dao
interface MissionsDao : BaseDao<MissionsModel, MutableList<MissionsModel>> {

    @Query("SELECT * FROM MissionsModel")
    suspend fun getAllMissions(): MutableList<MissionsModel>

    @Query("DELETE FROM missionsmodel")
    suspend fun deleteAll()
}