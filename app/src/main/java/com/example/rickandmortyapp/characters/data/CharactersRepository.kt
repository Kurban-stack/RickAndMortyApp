package com.example.rickandmortyapp.characters.data

import com.example.rickandmortyapp.characters.data.entity.CharacterResponse
import com.example.rickandmortyapp.characters.data.entity.GetCharactersResponse
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val api: RickAndMortyApi) {
    suspend fun getCharacters(): GetCharactersResponse {
        val charactersResponse = api.getCharacters()
        return charactersResponse
    }
    suspend fun getCharacter(characterId: String): CharacterResponse {
        val characterResponse = api.getCharacter(characterId) // TODO
        return characterResponse
    }
}