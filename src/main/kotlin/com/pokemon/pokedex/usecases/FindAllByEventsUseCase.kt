package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.domain.toResponse
import com.pokemon.pokedex.infrastructure.http.payload.response.PokemonResponse
import com.pokemon.pokedex.infrastructure.mongodb.entity.toDomain
import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration

@Service
class FindAllByEventsUseCase(
    private val repository: PokemonRepository
) {

    fun execute(delay: Long): Flux<PokemonResponse> = repository
        .findAll()
        .map { it.toDomain().toResponse() }
        .delayElements(Duration.ofSeconds(delay))

}