package com.nicos.ships.data.room_database.ships

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nicos.ships.data.room_database.init_database.MyRoomDatabase

/**
 * One to Many
 * */
@Entity
data class MissionsModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String?,
    var flight: Int?,
    var ship_id_missions: String?
) {

    companion object {
        suspend fun insertTheMissions(
            missionsModelList: MutableList<MissionsModel>,
            shipId: String,
            myRoomDatabase: MyRoomDatabase
        ) {
            val missionsList = mutableListOf<MissionsModel>()
            missionsModelList.forEach { mission ->
                mission.ship_id_missions = shipId
                missionsList.add(mission)
            }
            myRoomDatabase.missionsDao().insertOrReplaceList(missionsList)
        }
    }
}