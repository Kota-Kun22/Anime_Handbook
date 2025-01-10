package com.example.anime_handbook.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.anime_handbook.utiles.Constants.HERO_REMOTE_KEY_DATABASE_TABLE

@Entity(tableName = HERO_REMOTE_KEY_DATABASE_TABLE)
data class HeroRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val prevPage:Int?,
    val nextPage:Int?)
/** these are the key that interacts with the remote mediator implementation use to tell the backend what to load next and what to load previous */