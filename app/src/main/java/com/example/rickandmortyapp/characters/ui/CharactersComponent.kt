package com.example.rickandmortyapp.characters.ui

import androidx.compose.runtime.Composable
import com.example.rickandmortyapp.characters.ui.viewstate.CharactersViewState
import kotlinx.coroutines.flow.StateFlow

interface CharactersComponent {
    val state: StateFlow<CharactersViewState>

    @Composable fun Content()

}