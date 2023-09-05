package com.example.kotlin.pokedexapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.pokedexapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity: Activity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : PokemonAdapter = PokemonAdapter()
    private lateinit var data:ArrayList<PokemonBase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        getPokemonList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    //We make the call from the Main Activity to the Internet (Interface)
    private fun getPokemonList(){
        //Dispatchers.IO for calls to internet in coroutines
        CoroutineScope(Dispatchers.IO).launch {
            val pokemonRepository = PokemonRepository()
            val result:PokedexObject? = pokemonRepository.getPokemonList(Constants.MAX_POKEMON_NUMBER)
            CoroutineScope(Dispatchers.Main).launch {
                setUpRecyclerView(result?.results!!)
            }
        }
    }

    private fun setUpRecyclerView(dataForList:ArrayList<PokemonBase>){
        binding.RVPokemon.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVPokemon.layoutManager = linearLayoutManager
        //This refers to Activity which is the Context
        adapter.PokemonAdapter(dataForList,this)
        binding.RVPokemon.adapter = adapter
    }

}