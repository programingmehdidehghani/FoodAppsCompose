package com.example.foodapps.presention.componets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodapps.presention.ui.recipe_list.FoodCategory

@Composable
fun FoodCategoryChip(
    category: String,
    onExecuteSearch: (String) -> Unit
){
    Surface(
        modifier = Modifier.padding(end = 8.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.large
    ) {

    }
}