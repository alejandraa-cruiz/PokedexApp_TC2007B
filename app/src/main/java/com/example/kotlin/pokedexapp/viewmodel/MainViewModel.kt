package com.example.kotlin.pokedexapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.pokedexapp.model.PokedexObject
import com.example.kotlin.pokedexapp.model.PokemonRepository
import com.example.kotlin.pokedexapp.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val pokedexObjectLiveData = MutableLiveData<PokedexObject>()

    fun getPokemonList(){
        viewModelScope.launch(Dispatchers.IO) {
            val pokemonRepository = PokemonRepository()
            val result: PokedexObject? = pokemonRepository.getPokemonList(Constants.MAX_POKEMON_NUMBER)
            Log.d("Salida", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                pokedexObjectLiveData.postValue(result)
            }
        }
    }
}