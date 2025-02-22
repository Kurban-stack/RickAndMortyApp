package com.example.rickandmortyapp.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.rickandmortyapp.characterdetails.ui.CharacterDetailsComponent
import com.example.rickandmortyapp.characters.ui.CharactersComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    @Composable
    fun Content()

    sealed interface Child {
        data class Characters(val component: CharactersComponent) : Child
        data class Details(val component: CharacterDetailsComponent) : Child
    }
}