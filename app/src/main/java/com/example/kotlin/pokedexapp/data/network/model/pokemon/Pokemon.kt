package com.example.kotlin.pokedexapp.data.network.model.pokemon

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name: String,
    val sprites: com.example.kotlin.pokedexapp.data.network.model.pokemon.Sprites,

    )