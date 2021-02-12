package com.example.dogbreeds.model.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface DogsAPI {

    @GET("breeds/list")
    suspend fun fetchDogsData() : Response<List<DogsBreeds>>

    //@GET("breed/{breed}/images")
    //suspend fun fetchBreeds(@Path("breed") breed : String) : Response

}