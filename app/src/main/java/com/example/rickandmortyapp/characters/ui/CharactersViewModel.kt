package com.example.rickandmortyapp.characters.ui

import com.example.rickandmortyapp.characters.domain.GetCharactersUseCase
import com.example.rickandmortyapp.characters.domain.entity.toViewState
import com.example.rickandmortyapp.characters.ui.viewstate.CharactersViewState
import com.example.rickandmortyapp.core.ui.InstanceKeeperViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharactersViewModel (private val getCharactersUseCase: GetCharactersUseCase) :
    InstanceKeeperViewModel() {

    private val mutableState: MutableStateFlow<CharactersViewState> =
        MutableStateFlow(CharactersViewState.Loading)
    val state: StateFlow<CharactersViewState>
        get() = mutableState

    init {
        fetchAllCharacters()
    }

    private fun fetchAllCharacters() {
        viewModelScope.launch {
            try {
                val characters = getCharactersUseCase()
                mutableState.value = CharactersViewState.Success(characters.map { it.toViewState() })
            } catch (e: Exception) {
                mutableState.value =
                    CharactersViewState.Error(e.message ?: "Unknown error")
            }
        }
    }

}