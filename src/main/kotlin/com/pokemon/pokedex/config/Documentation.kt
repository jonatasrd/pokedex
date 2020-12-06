package com.pokemon.pokedex.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class Documentation {

    @Bean
    fun publicApi(): GroupedOpenApi? = GroupedOpenApi.builder()
        .setGroup("pokedex-public")
        .pathsToMatch("/api/v1/**")
        .build()


    @Bean
    fun pokedexAPI() = OpenAPI()
        .info(Info().title("Pokedex API")
            .description("Sample using Reactive Spring with Kotlin")
            .version("v0.0.1"))

}