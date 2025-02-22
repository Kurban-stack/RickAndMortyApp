package com.example.rickandmortyapp.characterdetails.domain

import com.example.rickandmortyapp.characters.data.CharactersRepository
import com.example.rickandmortyapp.characters.data.entity.toDomain
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharactersRepository
){
    suspend operator fun invoke(characterId: Int) = repository.getCharacter(characterId.toString()).toDomain()
}
