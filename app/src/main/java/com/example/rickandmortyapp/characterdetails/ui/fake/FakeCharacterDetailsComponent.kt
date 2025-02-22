package com.example.rickandmortyapp.characterdetails.ui.fake

import androidx.compose.runtime.Composable
import com.example.rickandmortyapp.characterdetails.ui.CharacterDetailsComponent
import com.example.rickandmortyapp.characterdetails.ui.CharacterDetailsContent
import com.example.rickandmortyapp.characterdetails.ui.viewstate.CharactersDetailsViewState
import com.example.rickandmortyapp.characters.domain.entity.Origin
import com.example.rickandmortyapp.characters.ui.viewstate.CharacterItemViewState
import kotlinx.coroutines.flow.MutableStateFlow

internal class FakeCharacterDetailsComponent : CharacterDetailsComponent {

    override val state = MutableStateFlow(
        CharactersDetailsViewState.Success(
            characterItem = CharacterItemViewState(
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
            )
        )
    )

    @Composable
    override fun Content() = CharacterDetailsContent(this)

}