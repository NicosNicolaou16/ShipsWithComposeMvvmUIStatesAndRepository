package com.nick.nickjetpackprojectandextras.room_database.ships

import androidx.room.Embedded
import androidx.room.Relation
import com.nicos.ships.data.room_database.ships.PositionEntity
import com.nicos.ships.data.room_database.ships.ShipsEntity

/**
 * One to One relationship
 * parentColumn = "id" ---->>>>>> is in the ship model and is the position model id to connect the position model with ship model
 * entityColumn = "shipId" ---->>>>>> is id of position model
 * */
data class ShipAndPositionModel(
    @Embedded
    val shipsEntity: ShipsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "shipId",
    )
    val positionEntity: PositionEntity,
)