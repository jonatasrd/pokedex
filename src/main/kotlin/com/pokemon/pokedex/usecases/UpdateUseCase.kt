package com.pokemon.pokedex.usecases

import com.pokemon.pokedex.domain.UpdatePokemon
import com.pokemon.pokedex.domain.toDomain
import com.pokemon.pokedex.domain.toModel
import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UpdateUseCase(
    private val repository: PokemonRepository
) {

    fun execute(id: String, updatePokemon: UpdatePokemon) =
        repository
            .findById(id)
            .flatMap { repository.save(updatePokemon.toDomain(it).toModel()) }
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())


}