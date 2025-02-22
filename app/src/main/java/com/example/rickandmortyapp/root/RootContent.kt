package com.example.rickandmortyapp.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.example.rickandmortyapp.core.ui.RickAndMortyTheme

@Composable
fun RootContent(component: RootComponent) {
    RickAndMortyTheme {
        Children(
            stack = component.stack,
            animation = stackAnimation(slide())
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.Characters -> {
                    instance.component.Content()
                }
                is RootComponent.Child.Details -> {
                    instance.component.Content()
                }
            }
        }
    }
}