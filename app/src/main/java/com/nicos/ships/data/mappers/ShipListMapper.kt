package com.nicos.ships.data.mappers

import com.nicos.ships.data.room_database.ships.ShipsEntity
import com.nicos.ships.domain.models.ShipListUI

fun ShipsEntity.toShipListUI(): ShipListUI {
    return ShipListUI(
        id = id,
        shipName = shipName,
        shipType = shipType,
        image = image
    )
}

fun MutableList<ShipsEntity>.toShipListUI(): MutableList<ShipListUI> {
    val list = mutableListOf<ShipListUI>()
    this.forEach {
        list.add(it.toShipListUI())
    }
    return list
}

fun ShipListUI.toShipsEntity(): ShipsEntity {
    return ShipsEntity(
        id = id,
        shipName = shipName,
        shipType = shipType,
        active = null,
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
        missions = mutableListOf(),
        url = null,
        image = image,
    )
}

fun MutableList<ShipListUI>.toShipsEntity(): MutableList<ShipsEntity> {
    val list = mutableListOf<ShipsEntity>()
    this.forEach {
        list.add(it.toShipsEntity())
    }
    return list
}