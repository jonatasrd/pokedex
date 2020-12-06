package com.pokemon.pokedex.domain

import com.pokemon.pokedex.infrastructure.mongodb.entity.AbilityModel

data class Ability(
    val name: String,
    val hidden: Boolean
)

internal fun Ability.toModel() =
    AbilityModel(
        name = this.name,
        hidden = this.hidden
    )

internal fun Set<Ability>.toModel() = this.mapTo(HashSet()) { it.toModel() }
