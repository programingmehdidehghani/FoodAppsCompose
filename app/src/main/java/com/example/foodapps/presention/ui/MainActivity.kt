package com.example.foodapps.presention.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.foodapps.R
import com.example.foodapps.presention.ui.recipe_list.RecipeListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_nav_host_fragment, RecipeListFragment())
            .commit()

      /*  setContent {
            FoodAppsTheme {
            }
        }*/
    }
}

