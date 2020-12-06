package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class FindAllByEventsUseCase(
    private val repository: PokemonRepository
) {

    fun execute(delay: Long) = repository.findAll().delayElements(Duration.ofSeconds(delay))

}