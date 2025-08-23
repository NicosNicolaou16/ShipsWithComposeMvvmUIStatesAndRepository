package com.nicos.ships.data.room_database.ships

import androidx.room.Embedded
import androidx.room.Relation

data class ShipWithRelationships(
    @Embedded
    val shipsEntity: ShipsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "shipId"
    )
    val shipAndPositionModel: ShipAndPositionModel?,
    @Relation(
        parentColumn = "id",
        entityColumn = "shipId"
    )
    val shipWithMissionsModel: MutableList<ShipWithMissionsModel>,
)
