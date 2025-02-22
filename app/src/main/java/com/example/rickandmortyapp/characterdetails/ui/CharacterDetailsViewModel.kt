package com.example.rickandmortyapp.characterdetails.ui

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.example.rickandmortyapp.characterdetails.domain.GetCharacterUseCase
import com.example.rickandmortyapp.characterdetails.ui.viewstate.CharactersDetailsViewState
import com.example.rickandmortyapp.characters.domain.entity.toViewState
import com.example.rickandmortyapp.core.ui.InstanceKeeperViewModel
//import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val characterId: Int
) : InstanceKeeperViewModel() {

    private val mutableState: MutableStateFlow<CharactersDetailsViewState> =
        MutableStateFlow(CharactersDetailsViewState.Loading)
    val state: StateFlow<CharactersDetailsViewState>
        get() = mutableState

    init {
        fetchCharacter()
    }

    private fun fetchCharacter() {
        viewModelScope.launch {
            try {
                val character = getCharacterUseCase(characterId)
                mutableState.value = CharactersDetailsViewState.Success(character.toViewState())
            } catch (e: Exception) {
                mutableState.value = CharactersDetailsViewState.Error(e.message ?: "Unknown error")
            }
        }
    }
}