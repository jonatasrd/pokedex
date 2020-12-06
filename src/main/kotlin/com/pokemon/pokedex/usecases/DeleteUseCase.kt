package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DeleteUseCase(
    private val repository: PokemonRepository
) {

    fun execute(id: String) = repository.findById(id)
        .flatMap { existingPokemon ->
            repository.delete(existingPokemon)
                .then(Mono.just(ResponseEntity.ok().build<Void>()))
        }
        .defaultIfEmpty(ResponseEntity.notFound().build())

}