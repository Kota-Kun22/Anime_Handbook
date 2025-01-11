package com.example.anime_handbook.data.local.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anime_handbook.domain.model.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

    @Query("SELECT * FROM hero_remote_key_table WHERE id =:id")
    suspend fun getRemoteKey(id:Int):HeroRemoteKey?

    @Query("DELETE FROM hero_remote_key_table")
    suspend fun deleteAllRemoteKeys()

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addAllRemoteKeys(heroRemoteKeys:List<HeroRemoteKey>)


}