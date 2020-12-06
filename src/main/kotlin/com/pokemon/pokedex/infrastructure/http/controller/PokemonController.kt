package com.pokemon.pokedex.infrastructure.http.controller

import com.pokemon.pokedex.infrastructure.http.payload.request.CreatePokemonRequest
import com.pokemon.pokedex.infrastructure.http.payload.request.UpdatePokemonRequest
import com.pokemon.pokedex.infrastructure.http.payload.request.toPokemon
import com.pokemon.pokedex.usecases.CreateUseCase
import com.pokemon.pokedex.usecases.DeleteAllUseCase
import com.pokemon.pokedex.usecases.DeleteUseCase
import com.pokemon.pokedex.usecases.FindAllByEventsUseCase
import com.pokemon.pokedex.usecases.FindAllUseCase
import com.pokemon.pokedex.usecases.FindByIdUseCase
import com.pokemon.pokedex.usecases.UpdateUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@Tag(
    name = "Pokedex Operations",
    description = "CRUD for Pokedex and possibility to find pokemons by events"
)
@RestController
@RequestMapping("/api/v1/pokemons")
class PokemonController(
    private val findAllUseCase: FindAllUseCase,
    private val findByIdUseCase: FindByIdUseCase,
    private val createUseCase: CreateUseCase,
    private val updateUseCase: UpdateUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val deleteAllUseCase: DeleteAllUseCase,
    private val findAllByEventsUseCase: FindAllByEventsUseCase
) {

    @Operation(summary = "Find all Pokemons")
    @GetMapping
    fun getAllPokemons() = findAllUseCase.execute()

    @Operation(summary = "Find a Pokemon by id")
    @ApiResponses(
        ApiResponse(
            responseCode = "404",
            description = "Not Found"
        )
    )
    @GetMapping("/{id}")
    fun getPokemon(@PathVariable id: String) = findByIdUseCase.execute(id)

    @Operation(summary = "Find all Pokemons by events")
    @GetMapping(value = ["/events/{delay}"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getPokemonByEvents(@PathVariable delay: Long) = findAllByEventsUseCase.execute(delay)

    @Operation(summary = "Create a new Pokemon")
    @ApiResponses(
        ApiResponse(
            responseCode = "400",
            description = "Bad Request (e.g. payload validation)"
        )
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePokemon(@RequestBody request: CreatePokemonRequest) = createUseCase.execute(request.toPokemon())

    @Operation(summary = "Update a Pokemon")
    @ApiResponses(
        ApiResponse(
            responseCode = "400",
            description = "Bad Request (e.g. payload validation)"
        ),
        ApiResponse(
            responseCode = "404",
            description = "Not Found"
        )
    )
    @PutMapping("{id}")
    fun updatePokemon(@PathVariable(value = "id") id: String, @RequestBody request: UpdatePokemonRequest) =
        updateUseCase.execute(id, request.toPokemon())

    @Operation(summary = "Delete a Pokemon")
    @ApiResponses(
        ApiResponse(
            responseCode = "404",
            description = "Not Found"
        )
    )
    @DeleteMapping("{id}")
    fun deletePokemon(@PathVariable(value = "id") id: String) = deleteUseCase.execute(id)

    @Operation(summary = "Delete all Pokemons")
    @DeleteMapping
    fun deleteAllPokemons() = deleteAllUseCase.execute()

}