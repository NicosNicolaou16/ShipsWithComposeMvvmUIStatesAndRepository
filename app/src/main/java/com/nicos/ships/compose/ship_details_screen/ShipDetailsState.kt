package com.nicos.ships.compose.ship_details_screen

import com.nicos.ships.data.room_database.ships.ShipsEntity

data class ShipDetailsState(
    val shipModel: ShipsEntity? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
