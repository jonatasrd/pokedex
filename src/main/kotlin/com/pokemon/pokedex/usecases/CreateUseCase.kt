package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.domain.Pokemon
import com.pokemon.pokedex.domain.toModel
import com.pokemon.pokedex.domain.toResponse
import com.pokemon.pokedex.infrastructure.http.payload.response.PokemonResponse
import com.pokemon.pokedex.infrastructure.mongodb.entity.toDomain
import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CreateUseCase(
    private val repository: PokemonRepository
) {

    fun execute(pokemon: Pokemon): Mono<PokemonResponse> =
        repository.save(pokemon.toModel()).map { it.toDomain().toResponse() }

}