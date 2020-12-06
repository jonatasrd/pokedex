package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.domain.toResponse
import com.pokemon.pokedex.infrastructure.mongodb.entity.toDomain
import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.stereotype.Service

@Service
class FindAllUseCase(
    private val repository: PokemonRepository
) {

    fun execute() = repository.findAll().map { it.toDomain().toResponse() }

}