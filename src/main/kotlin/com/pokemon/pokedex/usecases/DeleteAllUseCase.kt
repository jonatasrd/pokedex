package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.stereotype.Service

@Service
class DeleteAllUseCase(
    private val repository: PokemonRepository
) {

    fun execute() = repository.deleteAll()

}