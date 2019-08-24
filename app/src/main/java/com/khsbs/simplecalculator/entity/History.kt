package com.khsbs.simplecalculator.entity

import androidx.room.Entity

@Entity
data class History (
    var expr: String,
    var result: String
)