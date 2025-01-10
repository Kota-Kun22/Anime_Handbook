package com.example.anime_handbook.data.local.DAO

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anime_handbook.domain.model.Hero

/** Here in all my DAO  will contain 4 different functions to interact with the database
 * 1. Getting all the heros
 * 2. getting a selected hero with specific ID
 * 3. inserting and adding all heroes to our database
 * 4. deleting all the heroes */
@Dao
interface HeroDao{

    @Query("SELECT * FROM hero_table ORDER BY id ASC")
    fun getAllHeroes(): PagingSource<Int,Hero>/** here  paging source require key and value  where key is the actual value (INT)of the page and value is the hero */

    @Query("SELECT * FROM hero_table WHERE id=:heroId")
    fun getSelectedHero(heroId:Int):Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE)/** while adding any heroes if there is any conflicts  it will replace it*/
    suspend fun addHeroes(heroes:List<Hero>)

    @Query("DELETE FROM hero_table")
    suspend fun deleteAllHeroes()
}