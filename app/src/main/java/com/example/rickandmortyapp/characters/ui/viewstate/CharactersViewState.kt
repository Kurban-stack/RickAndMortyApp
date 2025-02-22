package com.example.rickandmortyapp.characters.ui.viewstate

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.rickandmortyapp.characters.domain.entity.Origin

@Stable
sealed class CharactersViewState {

    @Immutable
    data class Success(
        val characterItems: List<CharacterItemViewState>
    ): CharactersViewState()

    @Immutable
    data object Loading: CharactersViewState()

    @Immutable
    data class Error(val message: String) : CharactersViewState()

}

@Immutable
data class CharacterItemViewState(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val image: String,
)