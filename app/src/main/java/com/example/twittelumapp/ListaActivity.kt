package com.example.twittelumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import com.example.twittelumapp.Modelo.Tweet
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        fab_add.setOnClickListener {
            val intencao = Intent(this,TweetActivity::class.java)
            startActivity(intencao)
        }
    }

    override fun onResume() {
        super.onResume()

        val tweetDao = TwittelumDataBase.getInstance(this).tweetDao()
        val tweets: List<Tweet> = tweetDao.lista()
        lista_activity.adapter = ArrayAdapter<Tweet>(this,android.R.layout.simple_list_item_1,tweets)
    }
}
