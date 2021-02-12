package com.example.dogbreeds.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DogsEntity::class], version = 1)
abstract class BreedsDataBase : RoomDatabase(){

    abstract fun getBreedsDao(): DogsDao

    companion object {
        @Volatile
        private var INSTANCE : BreedsDataBase? = null

        fun getDataBase(context: Context) : BreedsDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BreedsDataBase::class.java,
                    "breeds_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}