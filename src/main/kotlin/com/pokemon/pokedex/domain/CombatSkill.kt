package com.pokemon.pokedex.domain

import com.pokemon.pokedex.infrastructure.mongodb.entity.CombatSkillModel

data class CombatSkill(
    val name: String,
    val strength: Int
)

internal fun CombatSkill.toModel() =
    CombatSkillModel(
        name = this.name,
        strength = this.strength
    )

internal fun Set<CombatSkill>.toModel() = this.mapTo(HashSet()) { it.toModel() }