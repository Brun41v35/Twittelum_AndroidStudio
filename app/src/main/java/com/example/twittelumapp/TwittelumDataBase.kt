package com.example.twittelumapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.twittelumapp.Modelo.Tweet
import java.security.AccessControlContext

@Database(entities = [Tweet::class], version = 1)
abstract class TwittelumDataBase : RoomDatabase() {

    abstract fun tweetDao(): TweetDao

    companion object {
        private var database: TwittelumDataBase? = null
        private val DATABASE = "TwittelumDB"

        fun getInstance (context: Context): TwittelumDataBase {
            return database ?: criaBanco (context).also { database = it}
        }

        fun criaBanco (context: Context): TwittelumDataBase {
            return Room.databaseBuilder(context,TwittelumDataBase::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }
}