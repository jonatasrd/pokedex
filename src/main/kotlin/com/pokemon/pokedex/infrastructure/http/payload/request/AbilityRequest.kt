package com.pokemon.pokedex.infrastructure.http.payload.request

import com.pokemon.pokedex.domain.Ability
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AbilityRequest(

    @NotBlank
    @field:Size(max = 100)
    @Schema(
        name = "Ability name",
        example = "Fly",
        required = true
    )
    val name: String,

    @Schema(
        name = "This ability is hidden?",
        required = true
    )
    val hidden: Boolean
)

internal fun AbilityRequest.toDomain() =
    Ability(
        name = this.name,
        hidden = this.hidden
    )

internal fun Set<AbilityRequest>.toDomain() = this.mapTo(HashSet()) { it.toDomain() }
