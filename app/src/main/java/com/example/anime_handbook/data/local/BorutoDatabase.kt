package com.example.anime_handbook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.anime_handbook.data.local.DAO.HeroDao
import com.example.anime_handbook.data.local.DAO.HeroRemoteKeyDao
import com.example.anime_handbook.domain.model.Hero
import com.example.anime_handbook.domain.model.HeroRemoteKey

@Database(entities = [Hero::class,HeroRemoteKey::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseConvertor::class)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemotekeyDao(): HeroRemoteKeyDao
}