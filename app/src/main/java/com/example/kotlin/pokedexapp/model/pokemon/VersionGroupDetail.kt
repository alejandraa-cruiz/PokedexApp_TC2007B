package com.example.kotlin.pokedexapp.model.pokemon

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: com.example.kotlin.pokedexapp.model.pokemon.MoveLearnMethod,
    val version_group: com.example.kotlin.pokedexapp.model.pokemon.VersionGroup
)