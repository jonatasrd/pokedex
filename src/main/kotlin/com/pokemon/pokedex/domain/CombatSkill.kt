package com.pokemon.pokedex.domain

import com.pokemon.pokedex.infrastructure.http.payload.response.CombatSkillResponse
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

internal fun CombatSkill.toResponse() =
    CombatSkillResponse(
        name = this.name,
        strength = this.strength
    )

internal fun Set<CombatSkill>.toResponse() = this.mapTo(HashSet()) { it.toResponse() }