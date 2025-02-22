package com.example.rickandmortyapp.characters.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.backhandler.BackCallback
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.example.rickandmortyapp.characters.domain.GetCharactersUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DefaultCharactersComponent @AssistedInject constructor(
    @Assisted("onCharacterClicked") private val onCharacterClicked: (characterId: Int) -> Unit,
    @Assisted("onBackClicked") private val onBackClicked: () -> Unit,
    @Assisted("componentContext") componentContext: ComponentContext,
    private val getCharactersUseCase: GetCharactersUseCase,
) : CharactersComponent, ComponentContext by componentContext{

    private val viewModel = instanceKeeper.getOrCreate { CharactersViewModel(getCharactersUseCase) } //TODO
    override val state = viewModel.state

    private val backCallback = BackCallback { onBackClicked() }

    init {
        backHandler.register(backCallback)

    }

    @Composable
    override fun Content() {
        CharactersContent(component = this, onCharacterClick = onCharacterClicked)
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("onCharacterClicked") onCharacterClicked: (characterId: Int) -> Unit,
            @Assisted("onBackClicked") onBackClicked: () -> Unit,
            @Assisted("componentContext") componentContext: ComponentContext
        ): DefaultCharactersComponent
    }
}