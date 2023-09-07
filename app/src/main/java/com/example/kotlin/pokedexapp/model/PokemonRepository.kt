package com.example.kotlin.pokedexapp.model

import com.example.kotlin.pokedexapp.model.NetworkModuleDI
import com.example.kotlin.pokedexapp.model.PokedexObject
import com.example.kotlin.pokedexapp.model.PokemonAPIService
import com.example.kotlin.pokedexapp.model.pokemon.Pokemon

class PokemonRepository() {
    //Define variable that calls API Service
    private lateinit var api: PokemonAPIService

    //Function with the same variables in PokemonAPIService function @GET ("pokemon")
    //? indicates function can return null
    //IMPORTANT! Initialize api variable!!!
    suspend fun getPokemonList(limit:Int): PokedexObject?{
        api = NetworkModuleDI()
        return try{
            api.getPokemonList(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    //Function with the same variables in PokemonAPIService function @GET("pokemon/{numberPokemon}")
    //Try catch is used for error control
    suspend fun getPokemonInfo(numberPokemon:Int): com.example.kotlin.pokedexapp.model.pokemon.Pokemon? {
        api = NetworkModuleDI()
        return try{
            api.getPokemonInfo(numberPokemon)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}