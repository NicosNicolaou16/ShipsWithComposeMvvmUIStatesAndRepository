package com.nicos.ships.domain.repositories.ships_repository

import com.nicos.ships.data.room_database.init_database.MyRoomDatabase
import com.nicos.ships.data.room_database.ships.ShipsModel
import com.nicos.ships.domain.remote.ship_service.ShipService
import com.nicos.ships.utils.generic_classes.HandlingError
import com.nicos.ships.utils.generic_classes.Resource
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class ShipsRepository @Inject constructor(
    private var shipService: ShipService,
    private var myRoomDatabase: MyRoomDatabase,
    private val handlingError: HandlingError
) {

    suspend fun fetchShipsData(): Resource<MutableList<ShipsModel>> {
        return try {
            val shipsList = shipService.getShips()
            saveShipDataIntoDatabase(shipsList)
            Resource.Success(shipsList)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "")
        }
    }

    private suspend fun saveShipDataIntoDatabase(shipsModelList: MutableList<ShipsModel>) {
        ShipsModel.insertTheShips(shipsModelList, myRoomDatabase).collect()
    }

    suspend fun queryToGetAllShips(): Resource<MutableList<ShipsModel>> {
        return try {
            val shipsList = myRoomDatabase.shipDao().getAllShips()
            saveShipDataIntoDatabase(shipsList)
            Resource.Success(shipsList)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = handlingError.handleErrorMessage(e))
        }
    }
}