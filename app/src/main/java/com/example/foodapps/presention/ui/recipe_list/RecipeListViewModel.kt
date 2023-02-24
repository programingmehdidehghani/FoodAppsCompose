package com.example.foodapps.presention.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapps.domain.model.Recipe
import com.example.foodapps.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject constructor(
    private val repository: RecipeRepository,
    private @Named("auth_token") val token: String
) : ViewModel() {

    val recipes : MutableState<List<Recipe>> = mutableStateOf(ArrayList())

    val selectedCategory : MutableState<FoodCategory?> = mutableStateOf(null)

    val query = mutableStateOf("")

    var categoryScrollPosition: Float = 0f

    val loading = mutableStateOf(false)

    init {
        newSearch()
    }

    fun newSearch(){
        viewModelScope.launch {
            loading.value = true

            delay(2000)

            val result = repository.search(
                token = token,
                page = 1,
                query = query.value
            )
            recipes.value = result

            loading.value = false
        }
    }

    fun onQueryChanged(query : String){
        this.query.value = query
    }

    fun onSelectedCategoryChanged(category: String){
        val newCategory = getFoodCategory(category)
        selectedCategory.value = newCategory
        onQueryChanged(category)
    }

    fun onChangeCategoryScrollPosition(position: Int){
        categoryScrollPosition = position
    }
}