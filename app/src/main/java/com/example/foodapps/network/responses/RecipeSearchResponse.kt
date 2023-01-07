package com.example.foodapps.network.responses

import com.example.foodapps.network.model.RecipeNetworkEntity
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(
    @SerializedName("count")
    var count : Int,

    @SerializedName("result")
    var recipes : List<RecipeNetworkEntity>
) {
}