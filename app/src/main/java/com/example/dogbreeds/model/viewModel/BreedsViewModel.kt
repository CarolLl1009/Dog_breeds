package com.example.dogbreeds.model.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dogbreeds.model.DogsRepository
import com.example.dogbreeds.model.local.BreedsDataBase
import com.example.dogbreeds.model.local.DogsEntity
import com.example.dogbreeds.model.remote.DogsBreeds
import kotlinx.coroutines.launch

class BreedsViewModel (application: Application) : AndroidViewModel(application)  {

    private val repository : DogsRepository
    val liveDataFromInternet : LiveData<List<DogsBreeds>>
    val allBreeds : LiveData<List<DogsEntity>>

    init {
        val dogsDao = BreedsDataBase.getDataBase(application).getBreedsDao()
        repository = DogsRepository(dogsDao)
        allBreeds = repository.listAllDogs
        viewModelScope.launch {
            repository.fetchDogsData() }
        liveDataFromInternet = repository.dataFromInternet

    }
}