package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.domain.toResponse
import com.pokemon.pokedex.infrastructure.mongodb.entity.toDomain
import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class FindByIdUseCase(
    private val repository: PokemonRepository
) {

    fun execute(id: String) = repository.findById(id)
        .map { pokemon -> ResponseEntity.ok(pokemon.toDomain().toResponse()) }
        .defaultIfEmpty(ResponseEntity.notFound().build())

}