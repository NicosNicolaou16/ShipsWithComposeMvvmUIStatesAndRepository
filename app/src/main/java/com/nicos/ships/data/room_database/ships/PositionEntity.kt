package com.nicos.ships.data.room_database.ships

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nicos.ships.data.room_database.init_database.MyRoomDatabase
import kotlinx.coroutines.flow.flow

@Entity
data class PositionEntity(
    @PrimaryKey(autoGenerate = true)
    var positionId: Long,
    var latitude: Double?,
    var longitude: Double?
) {

    constructor() : this(-1, null, null)

    companion object {
        suspend fun insertThePosition(
            positionEntity: PositionEntity,
            myRoomDatabase: MyRoomDatabase
        ) =
            flow {
                myRoomDatabase.positionDao().insertOrReplaceObject(positionEntity)
                emit(positionEntity)
            }
    }
}