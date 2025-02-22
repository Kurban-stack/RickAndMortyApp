package com.example.rickandmortyapp.characterdetails.ui.viewstate

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.rickandmortyapp.characters.ui.viewstate.CharacterItemViewState

@Stable
sealed class CharactersDetailsViewState {

    @Immutable
    data class Success(
        val characterItem: CharacterItemViewState
    ): CharactersDetailsViewState()

    @Immutable
    data object Loading: CharactersDetailsViewState()

    @Immutable
    data class Error(val message: String) : CharactersDetailsViewState()

}
