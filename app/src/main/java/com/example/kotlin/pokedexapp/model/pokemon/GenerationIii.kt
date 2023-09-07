package com.example.kotlin.pokedexapp.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIii(
    val emerald: com.example.kotlin.pokedexapp.model.pokemon.Emerald,
    @SerializedName("firered-leafgreen") val firered_leafgreen: com.example.kotlin.pokedexapp.model.pokemon.FireredLeafgreen,
    @SerializedName("ruby-sapphiren") val ruby_sapphire: com.example.kotlin.pokedexapp.model.pokemon.RubySapphire
)