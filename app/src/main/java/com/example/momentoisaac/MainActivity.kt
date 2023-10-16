package com.example.momentoisaac

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Crear los eventos de click para cada uno de los botones
        // TODO -> Esto es un trabajo muy burdo y simple, no escalable: Pendiente de mejorar
        val carinyosas = findViewById<ImageButton>(R.id.isaac_carinyosas).setOnClickListener(View.OnClickListener {
            // Replace "audioFilePath" with the path to your .mp3 file
            val audioFilePath = R.raw.carinyosas
            playYPause(audioFilePath)
        })
        val cabezon = findViewById<ImageButton>(R.id.isaac_cabezon).setOnClickListener(View.OnClickListener {
            // Replace "audioFilePath" with the path to your .mp3 file
            val audioFilePath = R.raw.eresuncabezon
            playYPause(audioFilePath)
        })
        val masculinidad = findViewById<ImageButton>(R.id.isaac_masculinidad).setOnClickListener(View.OnClickListener {
            // Replace "audioFilePath" with the path to your .mp3 file
            val audioFilePath = R.raw.masculinidadfrajil
            playYPause(audioFilePath)
        })
        val conyo = findViewById<ImageButton>(R.id.isaac_conyo).setOnClickListener(View.OnClickListener {
            // Replace "audioFilePath" with the path to your .mp3 file
            val audioFilePath = R.raw.queconyoestasdiciendo
            playYPause(audioFilePath)
        })
        val chupas = findViewById<ImageButton>(R.id.isaac_chupas).setOnClickListener(View.OnClickListener {
            // Replace "audioFilePath" with the path to your .mp3 file
            val audioFilePath = R.raw.simelachupasunrato
            playYPause(audioFilePath)
        })
        val todas = findViewById<ImageButton>(R.id.isaac_putas).setOnClickListener(View.OnClickListener {
            // Replace "audioFilePath" with the path to your .mp3 file
            val audioFilePath = R.raw.todasputas
            playYPause(audioFilePath)
        })
        val tio = findViewById<ImageButton>(R.id.isaac_tio).setOnClickListener(View.OnClickListener {
            // Replace "audioFilePath" with the path to your .mp3 file
            val audioFilePath = R.raw.vationo
            playYPause(audioFilePath)
        })
        val bandido = findViewById<ImageButton>(R.id.isaac_bandido).setOnClickListener(View.OnClickListener {
            // Replace "audioFilePath" with the path to your .mp3 file
            val audioFilePath = R.raw.yanosoyunbandido
            playYPause(audioFilePath)
        })
    }

    private fun playYPause(audioResourceID: Int) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, audioResourceID)
        }

        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
        } else {
            mediaPlayer?.seekTo(0)
            mediaPlayer?.start()
        }
    }

    // Limpiar el MediaPLayer cuando se ha acabado con él
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}