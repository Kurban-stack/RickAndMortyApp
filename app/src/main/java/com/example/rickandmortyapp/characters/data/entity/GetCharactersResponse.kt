package com.example.rickandmortyapp.characters.data.entity

import com.example.rickandmortyapp.characters.domain.entity.Character
import com.example.rickandmortyapp.characters.domain.entity.Origin

data class GetCharactersResponse(
    val results: List<CharacterResponse>
)

data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginResponse,
    val image: String,
)

data class OriginResponse(
    val name: String,
    val url: String,
)

fun GetCharactersResponse.toDomain() =
    this.results.map { it.toDomain() }

fun CharacterResponse.toDomain() =
    Character(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = Origin(this.origin.name, this.origin.url),
        image = this.image
    )