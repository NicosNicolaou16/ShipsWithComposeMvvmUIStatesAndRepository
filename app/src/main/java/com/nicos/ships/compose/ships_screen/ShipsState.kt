package com.nicos.ships.compose.ships_screen

import com.nicos.ships.data.room_database.ships.ShipsEntity

data class ShipsState(
    val shipsMutableList: MutableList<ShipsEntity>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
