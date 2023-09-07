package com.example.kotlin.pokedexapp.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.kotlin.pokedexapp.utils.Constants

class SplashscreenViewModel:ViewModel(){
    val finishedLoading = MutableLiveData<Boolean>()
        fun onCreate(){
            finishedLoading.postValue(false)
            viewModelScope.launch {
                delay(Constants.SPLASHCREEN_DURATION)
                finishedLoading.postValue(true)
            }
        }
}