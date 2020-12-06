package com.pokemon.pokedex.infrastructure.mongodb.entity

import com.pokemon.pokedex.domain.CombatSkill
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "CombatSkill")
data class CombatSkillModel(
    val name: String,
    val strength: Int
)

internal fun CombatSkillModel.toDomain() =
    CombatSkill(
        name = this.name,
        strength = this.strength
    )

internal fun Set<CombatSkillModel>.toDomain() = this.mapTo(HashSet()) { it.toDomain() }