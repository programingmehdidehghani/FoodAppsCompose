package com.example.foodapps.presention.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodapps.presention.componets.RecipeCard
import com.google.android.material.color.MaterialColors
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment(){

    private val viewModel : RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return ComposeView(requireContext()).apply {
             setContent {
                 val recipes = viewModel.recipes.value
                 val query = viewModel.query.value

                 Row {
                     Surface(
                         modifier = Modifier.fillMaxWidth(),
                         color = MaterialTheme.colors.primary,
                         elevation = 8.dp
                     ) {
                       Row(
                           modifier = Modifier.fillMaxWidth()
                       ) {
                           TextField(
                               modifier = Modifier
                                   .fillMaxWidth(0.9f)
                                   .padding(8.dp),
                               value = "Chicken",
                               onValueChange = { newValue->
                                   viewModel.onQueryChanged(newValue)
                               },
                               label = {
                                   Text(text = "Search")
                               },
                               keyboardOptions = KeyboardOptions(
                                   keyboardType = KeyboardType.Text,
                                   imeAction = ImeAction.Search
                               ),
                               leadingIcon = {
                                   Icon(Icons.Filled.Search)
                               },
                               textStyle = TextStyle(color = MaterialTheme.colors.onSurface)
                           )

                       }

                         ScrollableTabRow(modifier = Modifier.fillMaxWidth()){
                             for (category in getAllFoodCategories()){
                                  Text(
                                      text = category.value,
                                      style = MaterialTheme.typography.body2
                                  )
                             }
                         }
                             

                     }

                 }

                 LazyColumn{
                     itemsIndexed(
                         items = recipes
                     ){ index, recipe ->
                         RecipeCard(recipe = recipe, onClick = {})
                     }
                 }
             }
         }
    }
}