package com.nicos.ships.data.mappers

import com.nicos.ships.data.room_database.ships.ShipsEntity
import com.nicos.ships.domain.models.ShipDetailsUI

fun ShipsEntity.toShipDetailsUI(): ShipDetailsUI {
    return ShipDetailsUI(
        id = id,
        shipName = shipName,
        shipType = shipType,
        active = active,
        missionsEntity = missions
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
        image = null,
    )
}