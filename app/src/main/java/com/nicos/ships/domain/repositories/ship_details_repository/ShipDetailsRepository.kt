package com.nicos.ships.domain.repositories.ship_details_repository

import com.nicos.ships.data.room_database.init_database.MyRoomDatabase
import com.nicos.ships.data.room_database.ships.ShipsModel
import com.nicos.ships.utils.generic_classes.HandlingError
import com.nicos.ships.utils.generic_classes.Resource
import javax.inject.Inject

class ShipDetailsRepository @Inject constructor(
    private val myRoomDatabase: MyRoomDatabase,
    private val handlingError: HandlingError,
) {

    suspend fun queryShipById(id: String): Resource<ShipsModel?> {
        return try {
            Resource.Success(ShipsModel.getShipById(id, myRoomDatabase))
        } catch (e: Exception) {
            Resource.Error(message = handlingError.handleErrorMessage(e))
        }
    }
}