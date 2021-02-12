package com.example.dogbreeds.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dogbreeds.model.local.DogsDao
import com.example.dogbreeds.model.local.DogsEntity
import com.example.dogbreeds.model.remote.DogsBreeds
import com.example.dogbreeds.model.remote.RetrofitClient

class DogsRepository (private val dogsDao: DogsDao){

    private val retrofitClient = RetrofitClient.getRetrofit()
    val dataFromInternet = MutableLiveData<List<DogsBreeds>>()
    val listAllDogs : LiveData<List<DogsEntity>> = dogsDao.getAllDogs()

    fun convertedData (dogsBreeds : DogsBreeds) : List<DogsEntity>{
        val listado = mutableListOf<DogsEntity>()
        dogsBreeds.message.map {
            listado.add(DogsEntity(it))
        }
        return listado
    }

    suspend fun fetchDogsData() {
        try {
            val response = retrofitClient.fetchDogsData()
            when (response.code()){
                in 200..299 -> response.body()?.let { dogsDao.insertAllDogs(convertedData(it[0]))}
                in 300..301 -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")

            }

        } catch (t : Throwable) {
            Log.e("REPO", "${t.message}")
        }
    }
}