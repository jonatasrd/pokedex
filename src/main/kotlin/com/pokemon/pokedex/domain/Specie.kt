package com.pokemon.pokedex.domain

import com.pokemon.pokedex.infrastructure.mongodb.entity.SpecieModel

data class Specie(
    val name: String,
    val rarity: Int
)

internal fun Specie.toModel() =
    SpecieModel(
        name = this.name,
        rarity = this.rarity
    )
