package com.example.dogbreeds.model.remote

import com.google.gson.annotations.SerializedName

data class DogsBreeds(
    @SerializedName("message")
    val message: List<String>
)