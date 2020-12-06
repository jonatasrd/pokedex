package com.pokemon.pokedex.infrastructure.http.payload.request

import com.pokemon.pokedex.domain.UpdatePokemon
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Tag(name = "UpdatePokemonRequest")
data class UpdatePokemonRequest(

    @field:Size(max = 200)
    @NotBlank
    @Schema(
        name = "Pokemon name",
        required = false,
        example = "Charizard"
    )
    val name: String?,

    @field:NotNull
    @field:Valid
    @Schema(
        name = "Pokemon specie",
        required = false
    )
    val specie: SpecieRequest?,

    @Schema(
        name = "Pokemon weight",
        example = "10.8",
        required = false,
    )
    val weight: Double?,

    @Schema(
        name = "Pokemon height",
        example = "100.2",
        required = false,
    )
    val height: Double?,

    @field:Min(1)
    @field:Max(100)
    @Schema(
        name = "Pokemon experience (1 is lowest and 100 is highest) - If not passed in payload, assumes 1 as default value",
        required = false,
        example = "99"
    )
    val baseExperience: Int?,

    @field:NotEmpty
    @field:Valid
    @Schema(
        name = "Pokemon ability, must have at least one",
        required = false,
    )
    val abilities: Set<AbilityRequest>?,

    @field:NotEmpty
    @field:Valid
    @Schema(
        name = "Pokemon combat skills, must have at least one",
        required = true,
    )
    val combatSkills: Set<CombatSkillRequest>
)

internal fun UpdatePokemonRequest.toPokemon() =
    UpdatePokemon(
        name = this.name,
        specie = this.specie?.toDomain(),
        weight = this.weight,
        height = this.height,
        baseExperience = this.baseExperience ?: 1,
        abilities = this.abilities?.toDomain(),
        combatSkills = this.combatSkills.toDomain()
    )
