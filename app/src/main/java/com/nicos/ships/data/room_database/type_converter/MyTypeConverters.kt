package com.nicos.ships.data.room_database.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nicos.ships.data.room_database.ships.MissionsEntity
import com.nicos.ships.data.room_database.ships.PositionModel

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
    fun fromStringToPositions(value: String): PositionModel? {
        return Gson().fromJson(value, object : TypeToken<PositionModel>() {}.type)
    }

    @TypeConverter
    fun fromPositionToString(positionModel: PositionModel): String = Gson().toJson(positionModel)
}


