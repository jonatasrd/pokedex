package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.domain.Pokemon
import com.pokemon.pokedex.domain.toModel
import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.stereotype.Service

@Service
class CreateUseCase(
    private val repository: PokemonRepository
) {

    fun execute(pokemon: Pokemon) = repository.save(pokemon.toModel())

}