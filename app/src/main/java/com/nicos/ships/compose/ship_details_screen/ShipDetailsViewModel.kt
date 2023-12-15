package com.nicos.ships.compose.ship_details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicos.ships.data.room_database.ships.ShipsModel
import com.nicos.ships.domain.repositories.ship_details_repository.ShipDetailsRepository
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
class ShipDetailsViewModel @Inject constructor(
    private val shipDetailsRepository: ShipDetailsRepository,
    private val handlingError: HandlingError
) :
    ViewModel() {

    val shipDetailsState = MutableStateFlow<ShipDetailsState>(ShipDetailsState())

    fun queryShipById(id: String) = viewModelScope.launch {
        flow {
            val shipsModel: ShipsModel? = shipDetailsRepository.queryShipById(id)
            emit(shipsModel)
        }.flowOn(Dispatchers.Default)
            .catch { e ->
                shipDetailsState.value =
                    shipDetailsState.value.copy(
                        isLoading = false,
                        error = handlingError.handleErrorMessage(e)
                    )
            }.collect {
                if (it != null) {
                    shipDetailsState.value =
                        shipDetailsState.value.copy(
                            isLoading = false,
                            shipModel = it
                        )
                }
            }
    }
}