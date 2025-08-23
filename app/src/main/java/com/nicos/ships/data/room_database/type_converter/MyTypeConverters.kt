package com.nicos.ships.data.room_database.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nicos.ships.data.room_database.ships.MissionsEntity
import com.nicos.ships.data.room_database.ships.PositionEntity

class ConverterMission {
    @TypeConverter
    fun fromStringToMissionsList(value: String): MutableList<MissionsEntity>? {
        return Gson().fromJson(value, object : TypeToken<MutableList<MissionsEntity>>() {}.type)
    }

    @TypeConverter
    fun fromMissionsListToString(list: MutableList<MissionsEntity>?): String = Gson().toJson(list)
}

class ConverterPosition {

    @TypeConverter
    fun fromStringToPositions(value: String): PositionEntity? {
        return Gson().fromJson(value, object : TypeToken<PositionEntity>() {}.type)
    }

    @TypeConverter
    fun fromPositionToString(positionEntity: PositionEntity): String = Gson().toJson(positionEntity)
}


