package com.example.foodapps.presention.ui.recipe_list

import androidx.lifecycle.ViewModel
import com.example.foodapps.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
 constructor(
   private val repository:  RecipeRepository,
   private @Named("auth_token") val token: String
 ) : ViewModel() {

     init {

     }

    fun getRepo() = repository

    fun getToken() = token
}