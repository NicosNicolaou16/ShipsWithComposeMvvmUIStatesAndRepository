package com.nicos.ships.compose.ship_details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicos.ships.domain.repositories.ship_details_repository.ShipDetailsRepository
import com.nicos.ships.utils.generic_classes.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipDetailsViewModel @Inject constructor(
    private val shipDetailsRepository: ShipDetailsRepository,
) :
    ViewModel() {

    val shipDetailsState = MutableStateFlow<ShipDetailsState>(ShipDetailsState())

    fun queryShipById(id: String) = viewModelScope.launch(Dispatchers.IO) {
        shipDetailsState.value = shipDetailsState.value.copy(isLoading = true)
        shipDetailsRepository.queryShipById(id).let { resource ->
            when (resource) {
                is Resource.Success -> {
                    shipDetailsState.value =
                        shipDetailsState.value.copy(isLoading = false, shipModel = resource.data)
                }

                is Resource.Error -> {
                    shipDetailsState.value =
                        shipDetailsState.value.copy(isLoading = false, error = resource.message)
                }
            }
        }
    }
}