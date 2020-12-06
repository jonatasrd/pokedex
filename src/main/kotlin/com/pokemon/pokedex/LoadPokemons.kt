package com.pokemon.pokedex

import com.pokemon.pokedex.domain.Ability
import com.pokemon.pokedex.domain.CombatSkill
import com.pokemon.pokedex.domain.Pokemon
import com.pokemon.pokedex.domain.Specie
import com.pokemon.pokedex.domain.toModel
import com.pokemon.pokedex.infrastructure.mongodb.repository.PokemonRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class LoadPokemons(
    val repository: PokemonRepository
) : CommandLineRunner {

    override fun run(vararg args: String) {

        val pokemonFlux = Flux.just(
            Pokemon(
                null,
                "Pikachu",
                Specie("Electric", 1),
                6.0,
                0.4,
                45,
                setOf(
                    Ability("Thunder Jolt", false),
                    Ability("Lightning Rod", true)
                ),
                setOf(
                    CombatSkill("attack", 78),
                    CombatSkill("defense", 90)
                )
            ),
            Pokemon(
                null,
                "Bulbassauro",
                Specie("Semente", 1),
                23.0,
                6.09,
                0,
                setOf(
                    Ability("Fly", false)
                ),
                setOf(
                    CombatSkill("attack", 78)
                )
            ),
            Pokemon(
                null,
                "Bulbassauro",
                Specie("Semente", 1),
                23.0,
                6.09,
                0,
                setOf(
                    Ability("Fly", false)
                ),
                setOf(
                    CombatSkill("attack", 78)
                )
            ),
            Pokemon(
                null,
                "Bulbassauro",
                Specie("Semente", 1),
                23.0,
                6.09,
                0,
                setOf(
                    Ability("Fly", false)
                ),
                setOf(
                    CombatSkill("attack", 78)
                )
            )
        ).flatMap { repository.save(it.toModel()) }
        pokemonFlux
            .thenMany(repository.findAll())
            .subscribe { println(it) }

    }
}