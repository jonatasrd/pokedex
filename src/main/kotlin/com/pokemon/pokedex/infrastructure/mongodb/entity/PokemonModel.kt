package com.pokemon.pokedex.infrastructure.mongodb.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Pokemon")
data class PokemonModel(
    @Id
    val id: String?,
    val name: String,
    val specie: SpecieModel,
    val weight: Double,
    val height: Double,
    val baseExperience: Int,
    val abilities: Set<AbilityModel>,
    val combatSkills: Set<CombatSkillModel>
) {
    constructor(
        name: String,
        specie: SpecieModel,
        weight: Double,
        height: Double,
        baseExperience: Int,
        abilities: Set<AbilityModel>,
        combatSkills: Set<CombatSkillModel>
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


