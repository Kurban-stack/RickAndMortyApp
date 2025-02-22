package com.example.rickandmortyapp.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.example.rickandmortyapp.characterdetails.ui.DefaultCharacterDetailsComponent
import com.example.rickandmortyapp.characters.ui.DefaultCharactersComponent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.serialization.Serializable

class DefaultRootComponent @AssistedInject constructor(
    private val charactersComponentFactory: DefaultCharactersComponent.Factory,
    private val detailsComponentFactory: DefaultCharacterDetailsComponent.Factory,
    @Assisted("componentContext") componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = Config.Characters,
        handleBackButton = true,
        childFactory = ::child,
        serializer = Config.serializer()
    )

    @Composable
    override fun Content() {
        RootContent(this)
    }

    @OptIn(DelicateDecomposeApi::class)
    private fun child(
        config: Config,
        componentContext: ComponentContext
    ): RootComponent.Child {
        return when (config) {
            is Config.Characters -> {
                val component = charactersComponentFactory.create(
                    onCharacterClicked = {
                        navigation.push(Config.Details(it))
                    },
                    onBackClicked = { navigation.pop() },
                    componentContext = componentContext
                )
                RootComponent.Child.Characters(component)
            }

            is Config.Details -> {
                val component = detailsComponentFactory.create(
                    characterId = config.characterId,
                    onBackClicked = { navigation.pop() },
                    componentContext = componentContext
                )
                RootComponent.Child.Details(component)
            }

        }
    }

    @Serializable
    sealed interface Config {
        @Serializable
        data object Characters : Config

        @Serializable
        data class Details(val characterId: Int) : Config
    }


    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("componentContext") componentContext: ComponentContext
        ): DefaultRootComponent
    }
}