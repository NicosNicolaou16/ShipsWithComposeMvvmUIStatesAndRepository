package com.nicos.ships.compose.ships_screen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicos.ships.data.room_database.ships.ShipsModel
import com.nicos.ships.domain.repositories.ships_repository.ShipsRepository
import com.nicos.ships.utils.base_classes.BaseViewModel
import com.nicos.ships.utils.base_classes.HandlingError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipsViewModel @Inject constructor(
    private val shipsRepository: ShipsRepository,
    private val handlingError: HandlingError
) : ViewModel() {

    var shipsState = MutableStateFlow<ShipsState>(ShipsState())

    init {
        requestForShipsData()
        offline()
    }

    private fun requestForShipsData() = viewModelScope.launch {
        shipsState.value = shipsState.value.copy(isLoading = true)
        flow {
            kotlinx.coroutines.delay(5000)
            val shipsList =
                shipsRepository.fetchShipsData() //get the data from the server
            emit(shipsList)
        }.flowOn(Dispatchers.IO)
            .catch { e ->
                shipsState.value =
                    shipsState.value.copy(
                        isLoading = false,
                        error = handlingError.handleErrorMessage(e)
                    )
            }.collect {
                shipsState.value = shipsState.value.copy(isLoading = false, shipsMutableList = it)
            }
    }

    private fun offline() = viewModelScope.launch {
        shipsState.value = shipsState.value.copy(isLoading = true)
        flow {
            kotlinx.coroutines.delay(5000)
            val shipsList =
                shipsRepository.queryToGetAllShips() //get the data from the local database
            emit(shipsList)
        }.flowOn(Dispatchers.IO)
            .catch { e ->
                shipsState.value =
                    shipsState.value.copy(
                        isLoading = false,
                        error = handlingError.handleErrorMessage(e)
                    )
            }.collect {
                shipsState.value = shipsState.value.copy(isLoading = false, shipsMutableList = it)
            }
    }
}