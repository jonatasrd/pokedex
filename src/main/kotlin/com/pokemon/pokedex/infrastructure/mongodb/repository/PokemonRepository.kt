package com.pokemon.pokedex.infrastructure.mongodb.repository

import com.pokemon.pokedex.infrastructure.mongodb.entity.PokemonModel
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PokemonRepository : ReactiveMongoRepository<PokemonModel, String> {
}