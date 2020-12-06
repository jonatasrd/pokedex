package com.pokemon.pokedex.domain

import com.pokemon.pokedex.infrastructure.mongodb.entity.PokemonModel
import com.pokemon.pokedex.infrastructure.mongodb.entity.toDomain

data class UpdatePokemon(
    val name: String?,
    val specie: Specie?,
    val weight: Double?,
    val height: Double?,
    val baseExperience: Int?,
    val abilities: Set<Ability>?,
    val combatSkills: Set<CombatSkill>?
)

internal fun UpdatePokemon.toDomain(pokemon: PokemonModel) = Pokemon(
    id = pokemon.id,
    name = this.name ?: pokemon.name,
    specie = this.specie ?: pokemon.specie.toDomain(),
    weight = this.weight ?: pokemon.weight,
    height = this.height ?: pokemon.height,
    baseExperience = this.baseExperience ?: pokemon.baseExperience,
    abilities = this.abilities ?: pokemon.abilities.toDomain(),
    combatSkills = this.combatSkills ?: pokemon.combatSkills.toDomain()
)
