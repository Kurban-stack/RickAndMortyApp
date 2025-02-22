package com.example.rickandmortyapp.characterdetails.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.backhandler.BackCallback
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.example.rickandmortyapp.characterdetails.domain.GetCharacterUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DefaultCharacterDetailsComponent @AssistedInject constructor(
    @Assisted("characterId") private val characterId: Int,
    @Assisted("onBackClicked") private val onBackClicked: () -> Unit,
    @Assisted("componentContext") componentContext: ComponentContext,
    private val getCharactersUseCase: GetCharacterUseCase,
) : CharacterDetailsComponent, ComponentContext by componentContext{

    private val viewModel = instanceKeeper.getOrCreate { CharacterDetailsViewModel(getCharactersUseCase, characterId) }
    override val state = viewModel.state

    private val backCallback = BackCallback { onBackClicked() }

    init {
        backHandler.register(backCallback)
    }

    @Composable
    override fun Content() {
        CharacterDetailsContent(component = this)
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("characterId") characterId: Int,
            @Assisted("onBackClicked") onBackClicked: () -> Unit,
            @Assisted("componentContext") componentContext: ComponentContext
        ): DefaultCharacterDetailsComponent
    }
}