package com.example.twittelumapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.twittelumapp.Modelo.Tweet

@Dao
interface TweetDao {

    @Insert
    fun salva(tweet: Tweet)

    @Query("select * from Tweet")
    fun lista(): List<Tweet>
}