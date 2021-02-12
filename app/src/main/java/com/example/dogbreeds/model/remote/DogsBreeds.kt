package com.example.dogbreeds.model.remote

import com.google.gson.annotations.SerializedName

data class DogsBreeds(
    @SerializedName("breed")
    val message: List<String>
)