package com.example.twittelumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.twittelumapp.Modelo.Tweet

class TweetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tweet_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.tweet_menu_cadastrar -> {
                publicaTweet()
                finish()
            }
            android.R.id.home -> finish()
        }
        return true
    }

    private fun publicaTweet() {

        //Recuperando o Edit Text
        val campoDeMensagemDoTweet = findViewById<EditText>(R.id.tweet_mensagem)

        //Recuperando o conteudo do campo Edit Text
        val mensagemDoTweet: String = campoDeMensagemDoTweet.text.toString()

        val tweet = Tweet(mensagemDoTweet)
        val tweetDao = TwittelumDataBase.getInstance(this).tweetDao()
        tweetDao.salva(tweet)

        //Apenas mostrando o conteudo do Edit Text para o usuário
        Toast.makeText(this,"$tweet foi salvo com sucesso :D", Toast.LENGTH_LONG).show()
    }
}
