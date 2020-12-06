package com.pokemon.pokedex.infrastructure.http.payload.request

import com.pokemon.pokedex.domain.CombatSkill
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CombatSkillRequest(

    @NotBlank
    @field:Size(max = 100)
    @Schema(
        name = "Combat skill name",
        example = "attack",
        required = true
    )
    val name: String,

    @field:Min(1)
    @field:Max(10)
    @Schema(
        name = "Combat skill strength (1 is lowest and 10 is highest)",
        required = true,
        example = "5"
    )
    val strength: Int
)

internal fun CombatSkillRequest.toDomain() =
    CombatSkill(
        name = this.name,
        strength = this.strength
    )

internal fun Set<CombatSkillRequest>.toDomain() = this.mapTo(HashSet()) { it.toDomain() }