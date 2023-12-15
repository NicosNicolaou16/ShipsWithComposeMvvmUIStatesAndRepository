package com.nicos.ships.compose.ship_details_screen

import com.nicos.ships.data.room_database.ships.ShipsModel

data class ShipDetailsState(
    val shipModel: ShipsModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
