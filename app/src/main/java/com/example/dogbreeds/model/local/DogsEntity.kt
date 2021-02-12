package com.example.dogbreeds.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "dogs_table")
data class DogsEntity(
    @PrimaryKey
    @NotNull
    val breed : String

)
