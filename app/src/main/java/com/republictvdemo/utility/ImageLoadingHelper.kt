package com.republictvdemo.utility

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.republictvdemo.R


fun ImageView.loadImage(url: String, @DrawableRes placeholder: Int){
    Glide.with(context)
        .load(url)
        .placeholder(placeholder)
        .circleCrop()
        .into(this)
}