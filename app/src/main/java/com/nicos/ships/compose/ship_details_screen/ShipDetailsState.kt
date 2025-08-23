package com.nicos.ships.compose.ship_details_screen

import com.nicos.ships.domain.models.ShipDetailsUI

data class ShipDetailsState(
    val shipDetailsUI: ShipDetailsUI? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
