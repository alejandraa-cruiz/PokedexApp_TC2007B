package com.example.kotlin.pokedexapp.model.pokemon

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name: String,
    val sprites: com.example.kotlin.pokedexapp.model.pokemon.Sprites,

    )