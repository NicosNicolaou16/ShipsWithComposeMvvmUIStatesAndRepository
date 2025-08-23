package com.nick.nickjetpackprojectandextras.room_database.ships

import androidx.room.Embedded
import androidx.room.Relation
import com.nicos.ships.data.room_database.ships.MissionsEntity
import com.nicos.ships.data.room_database.ships.ShipsEntity

/**
 * One to Many relationships
 * parentColumn = "id" ---->>>>>> is the id of ship model
 * entityColumn = "shipId" ---->>>>>> is the id of ship model to connect the mission model with ship model
 * */
data class ShipWithMissionsModel(
    @Embedded
    val ship: ShipsEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "shipId"
    )
    val missions: MutableList<MissionsEntity>
)