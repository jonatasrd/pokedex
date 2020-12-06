package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.domain.toResponse
import com.pokemon.pokedex.infrastructure.http.payload.response.PokemonResponse
import com.pokemon.pokedex.infrastructure.mongodb.entity.toDomain
import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class FindAllUseCase(
    private val repository: PokemonRepository
) {

    fun execute(): Flux<PokemonResponse> = repository.findAll().map { it.toDomain().toResponse() }

}