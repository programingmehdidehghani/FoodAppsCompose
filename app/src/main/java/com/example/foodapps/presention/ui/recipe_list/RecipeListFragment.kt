package com.example.foodapps.presention.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodapps.presention.componets.CircularIndeterminateProgressBar
import com.example.foodapps.presention.componets.RecipeCard
import com.example.foodapps.presention.componets.SearchAppBar
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
                 val selectedCategory = viewModel.selectedCategory.value
                 val loading = viewModel.loading.value

                 Column {
                     
                     SearchAppBar(
                         query = query,
                         onQueryChanged = viewModel::onQueryChanged,
                         onExecuteSearch = viewModel::newSearch,
                         scrollPosition = viewModel.categoryScrollPosition,
                         selectedCategory = selectedCategory,
                         onSelectedCategoryChanged =
                          viewModel::onSelectedCategoryChanged,
                         onChangeCategoryScrollPosition =
                             viewModel::onChangeCategoryScrollPosition
                     )

                     Box(
                         modifier = Modifier.fillMaxSize()
                     ) {

                         LazyColumn{
                             itemsIndexed(
                                 items = recipes
                             ){ index, recipe ->
                                 RecipeCard(recipe = recipe, onClick = {})
                             }
                         }
                         CircularIndeterminateProgressBar(isDisplayed = loading)

                     }
                 }
             }
         }
    }
}