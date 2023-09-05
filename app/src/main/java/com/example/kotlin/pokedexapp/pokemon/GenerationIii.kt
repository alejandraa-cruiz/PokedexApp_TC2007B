package com.example.kotlin.pokedexapp.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIii(
    val emerald: Emerald,
    @SerializedName("firered-leafgreen") val firered_leafgreen: FireredLeafgreen,
    @SerializedName("ruby-sapphiren") val ruby_sapphire: RubySapphire
)