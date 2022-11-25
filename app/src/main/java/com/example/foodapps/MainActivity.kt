package com.example.foodapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_nav_host_fragment,RecipeListFragment())
            .commit()

      /*  setContent {
            FoodAppsTheme {
            }
        }*/
    }
}

