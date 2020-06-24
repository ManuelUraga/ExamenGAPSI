package com.inguraga.examengapsi.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

fun Context.toast(message:CharSequence,duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
}

fun ImageView.loadByUrl(url:String) = Picasso.get().load(url).into(this)