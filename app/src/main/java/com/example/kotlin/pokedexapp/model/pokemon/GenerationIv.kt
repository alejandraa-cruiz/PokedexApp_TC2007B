package com.example.kotlin.pokedexapp.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl") val diamond_pearl: com.example.kotlin.pokedexapp.model.pokemon.DiamondPearl,
    @SerializedName("heartgold-soulsilver") val heartgold_soulsilver: com.example.kotlin.pokedexapp.model.pokemon.HeartgoldSoulsilver,
    val platinum: com.example.kotlin.pokedexapp.model.pokemon.Platinum
)