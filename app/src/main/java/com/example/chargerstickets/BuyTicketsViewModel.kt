package com.example.chargerstickets

import androidx.lifecycle.*
import com.example.chargerstickets.data.ChargersTicketsDao
import com.example.chargerstickets.data.entities.Game
import kotlinx.coroutines.launch

class BuyTicketsViewModel(private val chargersTicketsDao: ChargersTicketsDao): ViewModel() {


    private val _games = MutableLiveData<List<Game>>()
    val games: LiveData<List<Game>> = _games

    private var lastSelectedChip: Int? = null

    init {
        filterGames("all")
    }

    fun filterGames(filter: String) {
        when (filter) {
            "all" -> {
                viewModelScope.launch {
                    _games.value = chargersTicketsDao.getAllGames()
                }
            }
            "home" -> {
                viewModelScope.launch {
                    _games.value = chargersTicketsDao.getHomeGames()
                }
            }
            "away" -> {
                viewModelScope.launch {
                    _games.value = chargersTicketsDao.getAwayGames()
                }
            }
        }
    }

    fun setLastSelectedChip(checkedChipIds: List<Int>) {
        lastSelectedChip = checkedChipIds[0]
    }

    fun getLastSelectedChip(): Int? {
        return lastSelectedChip
    }


}

class BuyTicketsViewModelFactory(private val chargersTicketsDao: ChargersTicketsDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BuyTicketsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BuyTicketsViewModel(chargersTicketsDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}