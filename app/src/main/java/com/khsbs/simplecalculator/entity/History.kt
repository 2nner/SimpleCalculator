package com.khsbs.simplecalculator.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var expr: String,
    var result: String
)