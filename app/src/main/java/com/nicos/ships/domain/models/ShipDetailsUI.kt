package com.nicos.ships.domain.models

import com.nicos.ships.data.room_database.ships.MissionsEntity

data class ShipDetailsUI(
    val id: String,
    val shipName: String?,
    val shipType: String?,
    val active: Boolean?,
    val missionsEntity: MutableList<MissionsEntity>
)