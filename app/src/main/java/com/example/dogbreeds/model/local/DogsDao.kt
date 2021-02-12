package com.example.dogbreeds.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface DogsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog : DogsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDogs(listDogs: List<DogsEntity>)

    @Update
    suspend fun updateDog(dog: DogsEntity)

    @Delete
    suspend fun deleteDog(dog: DogsEntity)

    @Query("DELETE FROM dogs_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM dogs_table ORDER BY breed DESC")
    fun getAllDogs() : LiveData<List<DogsEntity>>

    @Query("SELECT * FROM dogs_table WHERE breed = :id")
    fun getDogdByID(id: String) : LiveData<DogsEntity>


}