package com.example.foodapps.presention.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodapps.presention.componets.RecipeCard
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

                 Column {
                     Surface(
                         modifier = Modifier.fillMaxWidth(),
                         color = MaterialTheme.colors.primary,
                         elevation = 8.dp
                     ) {
                       Row(
                           modifier = Modifier.fillMaxWidth()
                       ) {

                       }
                     }
                     TextField(
                         value = "Chicken",
                         onValueChange = { newValue->
                             viewModel.onQueryChanged(newValue)
                         }
                     )
                     Spacer(modifier = Modifier.padding(10.dp))
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
}