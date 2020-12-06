package com.pokemon.pokedex.infrastructure.http.payload.response

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "AbilityResponse")
data class AbilityResponse(
    @Schema(
        name = "Ability name",
        example = "Fly"
    )
    val name: String,

    @Schema(
        name = "This ability is hidden?"
    )
    val hidden: Boolean
)
