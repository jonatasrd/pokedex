package com.pokemon.pokedex.infrastructure.http.payload.response

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "PokemonResponse")
data class PokemonResponse(
    @Schema(
        name = "Pokemon name",
        example = "Charizard"
    )
    val name: String,

    @Schema(
        name = "Pokemon specie"
    )
    val specie: SpecieResponse,

    @Schema(
        name = "Pokemon weight",
        example = "10.8"
    )
    val weight: Double,

    @Schema(
        name = "Pokemon height",
        example = "100.2"
    )
    val height: Double,

    @Schema(
        name = "Pokemon experience (1 is lowest and 100 is highest) - If not passed in payload, assumes 1 as default value",
        example = "99",
        minimum = "1",
        maximum = "100"
    )
    val baseExperience: Int?,

    @Schema(
        name = "Pokemon ability, must have at least one"
    )
    val abilities: Set<AbilityResponse>,

    @Schema(
        name = "Pokemon combat skills, must have at least one"
    )
    val combatSkills: Set<CombatSkillResponse>
)
