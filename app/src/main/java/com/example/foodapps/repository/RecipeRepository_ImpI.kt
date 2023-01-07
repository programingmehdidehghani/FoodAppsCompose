package com.example.foodapps.repository

import com.example.foodapps.domain.model.Recipe
import com.example.foodapps.domain.util.DomainMapper
import com.example.foodapps.network.RecipeService
import com.example.foodapps.network.model.RecipeDto
import com.example.foodapps.network.model.RecipeDtoMapper

class RecipeRepository_ImpI (
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
): RecipeRepository {
    override suspend fun search(token: String, id: Int, query: String):
      List<Recipe> {
        val result = recipeService.search(token,id,query)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        TODO("Not yet implemented")
    }
}