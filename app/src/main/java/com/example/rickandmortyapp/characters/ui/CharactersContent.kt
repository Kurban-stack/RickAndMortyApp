package com.example.rickandmortyapp.characters.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.core.ui.RickAndMortyTheme
import com.example.rickandmortyapp.characters.ui.fake.FakeCharactersComponent
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.rickandmortyapp.characters.ui.viewstate.CharacterItemViewState
import com.example.rickandmortyapp.characters.ui.viewstate.CharactersViewState

@Composable
internal fun CharactersContent(
    component: CharactersComponent,
    onCharacterClick: (id: Int) -> Unit
) {
    val state by component.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(Modifier.height(40.dp))

        when (state) {
            is CharactersViewState.Loading -> {
                //TODO
            }

            is CharactersViewState.Success -> {
                CharactersContent(
                    characters =
                    (state as CharactersViewState.Success).characterItems,
                    onCharacterClick = onCharacterClick,
                )
            }

            is CharactersViewState.Error -> {
                // TODO
            }
        }
    }
}

@Composable
private fun CharactersContent(
    characters: List<CharacterItemViewState>,
    onCharacterClick: (id: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        item { Header() }

        items(characters) { character: CharacterItemViewState ->
            CharacterCard(
                modifier = Modifier.clickable { onCharacterClick(character.id) },
                viewState = character
            )
        }
    }
}

@Composable
private fun Header() {
    Text(
        text = "Characters",
        color = Color.Black,
        fontSize = 31.sp,
        textAlign = TextAlign.Left,
        modifier = Modifier.wrapContentSize()
    )
}

@Composable
private fun CharacterCard(
    modifier: Modifier,
    viewState: CharacterItemViewState
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        AsyncImage(
            modifier = Modifier.clip(RoundedCornerShape(32.dp)),
            model = viewState.image,
            contentDescription = null
        )

        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = viewState.name,
                color = Color.Black,
                fontSize = 21.sp,
            )
            Text(
                text = "${viewState.species}, ${viewState.gender}",
                color = Color.Black,
                fontSize = 14.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharactersContentPreview() {
    RickAndMortyTheme {
        FakeCharactersComponent().Content()
    }
}