package com.example.rickandmortyapp.characterdetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.rickandmortyapp.characterdetails.ui.fake.FakeCharacterDetailsComponent
import com.example.rickandmortyapp.characterdetails.ui.viewstate.CharactersDetailsViewState
import com.example.rickandmortyapp.characters.ui.viewstate.CharacterItemViewState
import com.example.rickandmortyapp.core.ui.RickAndMortyTheme

@Composable
internal fun CharacterDetailsContent(
    component: CharacterDetailsComponent,
) {
    val state by component.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(Modifier.height(40.dp))

        when (state) {
            is CharactersDetailsViewState.Loading -> {
                //TODO
            }

            is CharactersDetailsViewState.Success -> {
                DetailsContent(viewState = (state as CharactersDetailsViewState.Success).characterItem)
            }

            is CharactersDetailsViewState.Error -> {
                // TODO
            }
        }
    }
}

@Composable
private fun DetailsContent(
    viewState: CharacterItemViewState,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .align(Alignment.CenterHorizontally),
            model = viewState.image,
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = viewState.name,
            color = Color.Black,
            fontSize = 32.sp,
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "${viewState.species}, ${viewState.gender}",
            color = Color.Black,
            fontSize = 24.sp,
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = viewState.status,
            color = Color.Black,
            fontSize = 20.sp,
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = viewState.origin.name,
            color = Color.Black,
            fontSize = 20.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharactersContentPreview() {
    RickAndMortyTheme {
        FakeCharacterDetailsComponent().Content()
    }
}