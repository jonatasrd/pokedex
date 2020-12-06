package com.pokemon.pokedex.domain

import com.pokemon.pokedex.infrastructure.http.payload.response.PokemonResponse
import com.pokemon.pokedex.infrastructure.mongodb.entity.PokemonModel

data class Pokemon(
    val id: String?,
    val name: String,
    val specie: Specie,
    val weight: Double,
    val height: Double,
    val baseExperience: Int,
    val abilities: Set<Ability>,
    val combatSkills: Set<CombatSkill>
) {
    constructor(
        name: String,
        specie: Specie,
        weight: Double,
        height: Double,
        baseExperience: Int,
        abilities: Set<Ability>,
        combatSkills: Set<CombatSkill>
    ) : this(
        id = null,
        name = name,
        specie = specie,
        weight = weight,
        height = height,
        baseExperience = baseExperience,
        abilities = abilities,
        combatSkills = combatSkills
    )
}

internal fun Pokemon.toModel() = PokemonModel(
    name = this.name,
    specie = this.specie.toModel(),
    weight = this.weight,
    height = this.height,
    baseExperience = this.baseExperience,
    abilities = this.abilities.toModel(),
    combatSkills = this.combatSkills.toModel()
)

internal fun Pokemon.toResponse() = PokemonResponse(
    name = this.name,
    specie = this.specie.toResponse(),
    weight = this.weight,
    height = this.height,
    baseExperience = this.baseExperience,
    abilities = this.abilities.toResponse(),
    combatSkills = this.combatSkills.toResponse()
)
