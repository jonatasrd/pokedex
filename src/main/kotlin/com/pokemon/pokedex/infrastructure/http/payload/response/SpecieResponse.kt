package com.pokemon.pokedex.infrastructure.http.payload.response

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "SpecieResponse")
data class SpecieResponse(
    @Schema(
        name = "Specie name",
        example = "Electric"
    )
    val name: String,

    @Schema(
        name = "Pokemon rarity (1 is lowest and 10 is highest) - If not passed in payload, assumes 1 as default value",
        example = "5"
    )
    val rarity: Int?
)
