package com.example.foodapps.repository

import com.example.foodapps.domain.model.Recipe
import com.example.foodapps.domain.util.DomainMapper
import com.example.foodapps.network.RecipeService
import com.example.foodapps.network.model.RecipeDto
import com.example.foodapps.network.model.RecipeDtoMapper
import javax.inject.Inject

class RecipeRepository_ImpI @Inject constructor(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
): RecipeRepository {
    override suspend fun search(token: String, id: Int, query: String):
      List<Recipe> {
        return mapper.toDomainList(recipeService.search(token,id,query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token,id))
    }
}