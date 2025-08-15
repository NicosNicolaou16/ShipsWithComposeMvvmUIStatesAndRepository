package com.nicos.ships.data.room_database.ships

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.nicos.ships.data.room_database.init_database.MyRoomDatabase

/**
 * One to Many
 * */
@Entity(
    foreignKeys = [ForeignKey(
        entity = ShipsModel::class,
        parentColumns = arrayOf("ship_id"),
        childColumns = arrayOf("shipId")
    )]
)
data class MissionsModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String?,
    var flight: Int?,
    var shipId: String?
) {

    companion object {
        suspend fun insertTheMissions(
            missionsModelList: MutableList<MissionsModel>,
            shipId: String,
            myRoomDatabase: MyRoomDatabase
        ) {
            val missionsList = mutableListOf<MissionsModel>()
            missionsModelList.forEach { mission ->
                mission.shipId = shipId
                missionsList.add(mission)
            }
            myRoomDatabase.missionsDao().insertOrReplaceList(missionsList)
        }
    }
}