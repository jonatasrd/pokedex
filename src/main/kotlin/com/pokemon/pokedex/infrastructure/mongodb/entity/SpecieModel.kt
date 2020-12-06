package com.pokemon.pokedex.infrastructure.mongodb.entity

import com.pokemon.pokedex.domain.Specie
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Specie")
data class SpecieModel(
    val name: String,
    val rarity: Int
)

internal fun SpecieModel.toDomain() =
    Specie(
        name = this.name,
        rarity = this.rarity
    )
