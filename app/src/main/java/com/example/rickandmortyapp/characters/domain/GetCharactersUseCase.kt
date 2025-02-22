package com.example.rickandmortyapp.characters.domain

import com.example.rickandmortyapp.characters.data.CharactersRepository
import com.example.rickandmortyapp.characters.data.entity.toDomain
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharactersRepository
){
    suspend operator fun invoke() = repository.getCharacters().toDomain()
}
