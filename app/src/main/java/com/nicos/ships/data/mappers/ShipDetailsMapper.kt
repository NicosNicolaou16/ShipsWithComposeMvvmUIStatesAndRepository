package com.nicos.ships.data.mappers

import com.nicos.ships.data.room_database.ships.ShipWithRelationships
import com.nicos.ships.data.room_database.ships.ShipsEntity
import com.nicos.ships.compose.ship_details_screen.ShipDetailsUI

fun ShipWithRelationships.toShipDetailsUI(): ShipDetailsUI {
    return ShipDetailsUI(
        id = this.shipsEntity.id,
        shipName = this.shipsEntity.shipName,
        shipType = this.shipsEntity.shipType,
        active = this.shipsEntity.active,
        missionsEntity = this.shipsEntity.missions,
        image = this.shipsEntity.image,
    )
}

fun ShipDetailsUI.toShipsEntity(): ShipsEntity {
    return ShipsEntity(
        id = id,
        shipName = shipName,
        shipType = shipType,
        active = active,
        imo = null,
        mmsi = null,
        abs = null,
        clazz = null,
        weightLbs = null,
        yearBuilt = null,
        homePort = null,
        status = null,
        speedKn = null,
        courseDeg = null,
        position = null,
        successfulLandings = null,
        attemptedLandings = null,
        missions = missionsEntity,
        url = null,
        image = image,
    )
}

fun ShipDetailsUI.toShipWithRelationships(): ShipWithRelationships {
    return ShipWithRelationships(
        shipsEntity = this.toShipsEntity(),
        positionEntity = null,
        missionsEntity = this.missionsEntity,
    )
}