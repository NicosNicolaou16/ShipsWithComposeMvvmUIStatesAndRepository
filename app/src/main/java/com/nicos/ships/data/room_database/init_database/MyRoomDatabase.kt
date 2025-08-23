package com.nicos.ships.data.room_database.init_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nicos.ships.data.room_database.ships.dao.MissionsDao
import com.nicos.ships.data.room_database.ships.MissionsEntity
import com.nicos.ships.data.room_database.ships.dao.PositionDao
import com.nicos.ships.data.room_database.ships.PositionEntity
import com.nicos.ships.data.room_database.ships.dao.ShipsDao
import com.nicos.ships.data.room_database.ships.ShipsModel
import com.nicos.ships.data.room_database.type_converter.ConverterMission
import com.nicos.ships.data.room_database.type_converter.ConverterPosition
import javax.inject.Inject

@Database(
    entities = [ShipsModel::class, PositionEntity::class, MissionsEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    ConverterPosition::class,
    ConverterMission::class,
)
abstract class MyRoomDatabase : RoomDatabase() {
    abstract fun shipDao(): ShipsDao
    abstract fun positionDao(): PositionDao
    abstract fun missionsDao(): MissionsDao

    @Inject
    internal lateinit var myRoomDatabase: MyRoomDatabase

    companion object {
        internal const val DB_NAME = "DB_NAME"
    }

    fun deleteAll() {
        myRoomDatabase.clearAllTables()
    }
}