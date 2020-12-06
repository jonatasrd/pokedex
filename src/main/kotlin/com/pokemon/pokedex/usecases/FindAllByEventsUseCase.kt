package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.domain.toResponse
import com.pokemon.pokedex.infrastructure.mongodb.entity.toDomain
import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class FindAllByEventsUseCase(
    private val repository: PokemonRepository
) {

    fun execute(delay: Long) = repository
        .findAll()
        .map { it.toDomain().toResponse() }
        .delayElements(Duration.ofSeconds(delay))

}