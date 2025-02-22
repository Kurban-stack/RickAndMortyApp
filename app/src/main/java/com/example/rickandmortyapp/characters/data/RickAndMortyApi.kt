package com.example.rickandmortyapp.characters.data

import com.example.rickandmortyapp.characters.data.entity.CharacterResponse
import com.example.rickandmortyapp.characters.data.entity.GetCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {
    @GET("character/")
    suspend fun getCharacters(): GetCharactersResponse

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String): CharacterResponse
}