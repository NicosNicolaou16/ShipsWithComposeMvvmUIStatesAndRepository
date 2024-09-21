package com.nicos.ships.compose.ships_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicos.ships.domain.repositories.ships_repository.ShipsRepository
import com.nicos.ships.utils.generic_classes.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipsViewModel @Inject constructor(
    private val shipsRepository: ShipsRepository,
) : ViewModel() {

    private val _shipsState = MutableStateFlow<ShipsState>(ShipsState())
    val shipsState: StateFlow<ShipsState> = _shipsState

    init {
        requestForShipsData()
        offline()
    }

    private fun requestForShipsData() = viewModelScope.launch(Dispatchers.IO) {
        _shipsState.value = shipsState.value.copy(isLoading = true)
        shipsRepository.fetchShipsData().let { resource ->
            when (resource) {
                is Resource.Success -> {
                    _shipsState.value =
                        shipsState.value.copy(isLoading = false, shipsMutableList = resource.data)
                }

                is Resource.Error -> {
                    _shipsState.value =
                        shipsState.value.copy(
                            isLoading = false,
                            error = resource.message
                        )
                }
            }
        }
    }

    private fun offline() = viewModelScope.launch(Dispatchers.IO) {
        _shipsState.value = shipsState.value.copy(isLoading = true)
        shipsRepository.queryToGetAllShips().let { resource ->
            when (resource) {
                is Resource.Success -> {
                    _shipsState.value =
                        shipsState.value.copy(isLoading = false, shipsMutableList = resource.data)
                }

                is Resource.Error -> {
                    _shipsState.value =
                        shipsState.value.copy(
                            isLoading = false,
                            error = resource.message
                        )
                }
            }
        }
    }
}