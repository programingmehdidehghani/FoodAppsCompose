package com.example.foodapps.presention.ui.recipe_list

enum class FoodCategory(val value: String){

    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut")
}

fun getAllFoodCategories() : List<FoodCategory>{
    return listOf(FoodCategory.CHICKEN,
        FoodCategory.BEEF, FoodCategory.SOUP, FoodCategory.DESSERT,
        FoodCategory.VEGETARIAN, FoodCategory.MILK, FoodCategory.VEGAN,FoodCategory.PIZZA,
        FoodCategory.DONUT
    )
}