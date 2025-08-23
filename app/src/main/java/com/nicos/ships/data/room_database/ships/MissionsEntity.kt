package com.nicos.ships.data.room_database.ships

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.nicos.ships.data.room_database.init_database.MyRoomDatabase

/**
 * One to Many
 * */
@Entity(
    indices = [Index(value = ["id"], unique = true), Index(value = ["shipId"])],
    foreignKeys = [ForeignKey(
        entity = ShipsEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("shipId"),
        onDelete = ForeignKey.CASCADE,
    )]
)
data class MissionsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String?,
    val flight: Int?,
    var shipId: String?
) {

    companion object {
        suspend fun insertTheMissions(
            missionsEntityList: MutableList<MissionsEntity>,
            shipId: String,
            myRoomDatabase: MyRoomDatabase
        ) {

            if (missionsEntityList.isEmpty()) return
            val missionsList = mutableListOf<MissionsEntity>()
            missionsEntityList.forEach { mission ->
                mission.shipId = shipId
                missionsList.add(mission)
            }
            myRoomDatabase.missionsDao().insertOrReplaceList(missionsList)
        }
    }
}