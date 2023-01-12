package com.example.foodapps.di

import com.example.foodapps.network.RecipeService
import com.example.foodapps.network.model.RecipeDtoMapper
import com.example.foodapps.repository.RecipeRepository
import com.example.foodapps.repository.RecipeRepository_ImpI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
       return RecipeRepository_ImpI(
           recipeService,recipeDtoMapper
       )
    }
}