package com.alanturing.cpifp.todo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    var id:Int = 0,

    val title:String,

    val description:String,

    val isCompleted: Boolean = false
) : Parcelable
