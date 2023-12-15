package com.nicos.ships.compose.ships_screen

import com.nicos.ships.data.room_database.ships.ShipsModel

data class ShipsState(
    val shipsMutableList: MutableList<ShipsModel>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
