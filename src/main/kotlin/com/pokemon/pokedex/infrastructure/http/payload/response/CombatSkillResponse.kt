package com.pokemon.pokedex.infrastructure.http.payload.response

import io.swagger.v3.oas.annotations.media.Schema

data class CombatSkillResponse(
    @Schema(
        name = "Combat skill name",
        example = "attack"
    )
    val name: String,

    @Schema(
        name = "Combat skill strength (1 is lowest and 10 is highest)",
        example = "5"
    )
    val strength: Int
)
