package com.example.foodapps.presention.ui.recipe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapps.domain.model.Recipe
import com.example.foodapps.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
constructor(
    private val repository: RecipeRepository,
    private @Named("auth_token") val token: String
) : ViewModel() {

    private val _recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    val recipe: LiveData<List<Recipe>> = _recipes

    init {
      viewModelScope.launch {
          val result = repository.search(
              token = token,
              page = 1,
              query = "chicken"
          )
          _recipes.value = result
      }
    }

}