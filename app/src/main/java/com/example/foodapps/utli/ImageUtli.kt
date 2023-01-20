package com.example.foodapps.utli

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.bumptech.glide.Glide

@SuppressLint("UnrememberedMutableState")
@Composable
fun loadPicture(
    url: String,
    @DrawableRes defaultImage: Int
): MutableState<Bitmap?>{

    val bitmapState : MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(AmbientContext.current)
}