package com.example.twittelumapp.Modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tweet(val mensagem: String,
     @PrimaryKey (autoGenerate = true) val id: Int = 0) {

}