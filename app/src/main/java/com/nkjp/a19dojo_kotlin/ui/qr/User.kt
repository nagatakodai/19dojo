package com.nkjp.a19dojo_kotlin.ui.qr

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["name","github","twitter"])
data class User(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "github")
    val github: String,
    @ColumnInfo(name = "twitter")
    val twitter: String
)
