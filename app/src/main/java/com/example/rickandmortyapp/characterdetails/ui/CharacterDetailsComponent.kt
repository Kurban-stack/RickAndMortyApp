package com.example.rickandmortyapp.characterdetails.ui

import androidx.compose.runtime.Composable
import com.example.rickandmortyapp.characterdetails.ui.viewstate.CharactersDetailsViewState
import com.example.rickandmortyapp.characters.ui.viewstate.CharactersViewState
import kotlinx.coroutines.flow.StateFlow

interface CharacterDetailsComponent {
    val state: StateFlow<CharactersDetailsViewState>

    @Composable fun Content()

}