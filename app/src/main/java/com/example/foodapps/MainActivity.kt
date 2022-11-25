package com.example.foodapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,RecipeListFragment())
            .commit()

      /*  setContent {
            FoodAppsTheme {
            }
        }*/
    }
}

