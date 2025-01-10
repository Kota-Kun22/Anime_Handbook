package com.example.anime_handbook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.anime_handbook.data.local.DAO.HeroDao
import com.example.anime_handbook.domain.model.Hero

@Database(entities = [Hero::class], version = 1, exportSchema = false)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
}