package com.pokemon.pokedex.infrastructure.http.payload.request

import com.pokemon.pokedex.domain.Specie
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SpecieRequest(

    @NotBlank
    @field:Size(max = 100)
    @Schema(
        name = "Specie name",
        example = "Electric",
        required = true
    )
    val name: String,

    @field:Min(1)
    @field:Max(10)
    @Schema(
        name = "Pokemon rarity (1 is lowest and 10 is highest) - If not passed in payload, assumes 1 as default value",
        required = false,
        example = "5"
    )
    val rarity: Int?
)

internal fun SpecieRequest.toDomain() =
    Specie(
        name = this.name,
        rarity = this.rarity ?: 1
    )
