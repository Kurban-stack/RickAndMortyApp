package com.example.rickandmortyapp.characters.domain.entity

import com.example.rickandmortyapp.characters.ui.viewstate.CharacterItemViewState

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val image: String,
)

data class Origin(
    val name: String,
    val url: String,
)

fun Character.toViewState() = CharacterItemViewState(
    id = this.id,
    name = this.name,
    status = this.status,
    species = this.species,
    type = this.type,
    gender = this.gender,
    origin = Origin(this.origin.name, this.origin.url),
    image = this.image
)