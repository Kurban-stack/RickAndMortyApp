package com.example.rickandmortyapp.characters.ui.fake

import androidx.compose.runtime.Composable
import com.example.rickandmortyapp.characters.domain.entity.Origin
import com.example.rickandmortyapp.characters.ui.CharactersComponent
import com.example.rickandmortyapp.characters.ui.CharactersContent
import com.example.rickandmortyapp.characters.ui.viewstate.CharacterItemViewState
import com.example.rickandmortyapp.characters.ui.viewstate.CharactersViewState
import kotlinx.coroutines.flow.MutableStateFlow

internal class FakeCharactersComponent : CharactersComponent {

    override val state = MutableStateFlow(
        CharactersViewState.Success(
            characterItems = listOf(
                CharacterItemViewState(
                    id = 1,
                    name = "Rick Sanchez",
                    status = "Alive",
                    type = "",
                    species = "Human",
                    gender = "Male",
                    origin = Origin(
                        name = "Earth (C-137)",
                        url = "https://rickandmortyapi.com/api/location/1"
                    ),
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                ),
                CharacterItemViewState(
                    id = 2,
                    name = "Johnny Depp",
                    status = "Alive",
                    type = "",
                    species = "Human",
                    gender = "Male",
                    origin = Origin(
                        name = "Earth (C-500A)",
                        url = "https://rickandmortyapi.com/api/location/23"
                    ),
                    image = "https://rickandmortyapi.com/api/character/avatar/183.jpeg",
                )
            )
        )
    )

    @Composable
    override fun Content() = CharactersContent(this, {})

}