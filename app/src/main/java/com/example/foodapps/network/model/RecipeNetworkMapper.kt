package com.example.foodapps.network.model

import com.example.foodapps.domain.model.Recipe
import com.example.foodapps.domain.util.EntityMapper

class RecipeNetworkMapper : EntityMapper<RecipeNetworkEntity,Recipe> {

    
    override fun mapFromEntity(entity: RecipeNetworkEntity): Recipe {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domainModel: Recipe): RecipeNetworkEntity {
        TODO("Not yet implemented")
    }


}