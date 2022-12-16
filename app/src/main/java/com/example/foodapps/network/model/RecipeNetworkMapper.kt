package com.example.foodapps.network.model

import com.example.foodapps.domain.model.Recipe
import com.example.foodapps.domain.util.EntityMapper

class RecipeNetworkMapper : EntityMapper<RecipeNetworkEntity,Recipe> {


    override fun mapFromEntity(entity: RecipeNetworkEntity): Recipe {
        return Recipe(
            id = entity.pk,
            title = entity.title,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            publisher = entity.publisher,
            sourceUrl = entity.sourceUrl,
            description = entity.description,
            cookingInstructions = entity.cookingInstructions,
            ingredients = entity.ingredients?: listOf(),
            dateAdded = entity.dateAdded,
            dateUpdated = entity.dateUpdated
        )
    }

    override fun mapToEntity(domainModel: Recipe): RecipeNetworkEntity {
        TODO("Not yet implemented")
    }


}