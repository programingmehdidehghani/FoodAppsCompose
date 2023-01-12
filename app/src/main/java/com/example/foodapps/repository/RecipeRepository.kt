package com.example.foodapps.repository

import com.example.foodapps.domain.model.Recipe

interface RecipeRepository {

    suspend fun search(token :String,id: Int,query: String): List<Recipe>

    suspend fun get(token: String,id: Int): Recipe
}