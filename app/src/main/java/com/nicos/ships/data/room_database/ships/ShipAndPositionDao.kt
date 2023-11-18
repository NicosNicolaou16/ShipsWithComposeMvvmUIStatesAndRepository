package com.nicos.ships.data.room_database.ships

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.ships.data.room_database.ships.ShipAndPositionModel

/**
 * One to One relationship Dao
 * */
@Dao
interface ShipAndPositionDao {

    @Transaction
    @Query("SELECT * FROM PositionModel")
    fun getShipAndPosition(): MutableList<ShipAndPositionModel>
}