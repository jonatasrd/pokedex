package com.pokemon.pokedex.infrastructure.mongodb.entity

import com.pokemon.pokedex.domain.Ability
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Ability")
data class AbilityModel(
    val name: String,
    val hidden: Boolean
)

internal fun AbilityModel.toDomain() =
    Ability(
        name = this.name,
        hidden = this.hidden
    )

internal fun Set<AbilityModel>.toDomain() = this.mapTo(HashSet()) { it.toDomain() }
