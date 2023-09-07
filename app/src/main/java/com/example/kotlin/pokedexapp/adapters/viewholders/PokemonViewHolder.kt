package com.example.kotlin.pokedexapp.adapters.viewholders

import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.pokedexapp.model.PokemonBase
import com.example.kotlin.pokedexapp.model.PokemonRepository
import com.example.kotlin.pokedexapp.databinding.ItemPokemonBinding
import com.example.kotlin.pokedexapp.model.pokemon.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PokemonBase, context: Context){
        binding.TVName.text = item.name
        //context is the active view
        getPokemonInfo(item.url,binding.IVPhoto,context)
    }

    private fun getPokemonInfo(url:String, imageView: ImageView, context: Context){
        //"https://pokeapi.co/api/v2/pokemon/23/"
        var pokemonStringNumber:String = url.replace("https://pokeapi.co/api/v2/pokemon/","")
        pokemonStringNumber = pokemonStringNumber.replace("/","")
        val pokemonNumber:Int = Integer.parseInt(pokemonStringNumber)

        CoroutineScope(Dispatchers.IO).launch {
            val pokemonRepository = PokemonRepository()
            val result: com.example.kotlin.pokedexapp.model.pokemon.Pokemon? = pokemonRepository.getPokemonInfo(pokemonNumber)
           // Log.d("Salida", result!!.sprites.other.official_artwork.front_default)
            //Glide is a image library for async upload of images
           CoroutineScope(Dispatchers.Main).launch {
                val urlImage = result?.sprites?.other?.official_artwork?.front_default.toString()
                Log.d("Salida",urlImage)
                val requestOptions =  RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }}
}