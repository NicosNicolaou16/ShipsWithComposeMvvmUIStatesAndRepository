package com.nicos.ships.compose.ships_screen

import com.nicos.ships.compose.ships_screen.ShipListUI

data class ShipsState(
    val shipsMutableList: MutableList<ShipListUI>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
