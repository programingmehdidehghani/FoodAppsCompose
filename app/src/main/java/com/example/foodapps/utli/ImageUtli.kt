package com.example.foodapps.utli

import android.graphics.drawable.Drawable
import com.bumptech.glide.request.transition.Transition


import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget

@SuppressLint("UnrememberedMutableState")
@Composable
fun loadPicture(
    url: String,
    @DrawableRes defaultImage: Int
): MutableState<Bitmap?>{

    val bitmapState : MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }
        })

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }
        })

    return bitmapState
}