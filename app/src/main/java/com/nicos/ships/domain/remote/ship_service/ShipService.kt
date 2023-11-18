package com.nicos.ships.domain.remote.ship_service

import com.nicos.ships.data.room_database.ships.ShipsModel
import retrofit2.http.GET

interface ShipService {

    @GET("v3/ships")
    suspend fun getShips(): MutableList<ShipsModel>
}