package com.example.kotlin.pokedexapp.model
import com.google.gson.annotations.SerializedName

//Define all API parameters inside the data class object
data class PokedexObject(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: ArrayList<PokemonBase>,
)
