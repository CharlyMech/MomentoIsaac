package com.example.momentoisaac

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private var idAudioActual: Int? = null
    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPrincipal: Button = findViewById(R.id.principal)
        val imageView: ImageView = findViewById(R.id.imagen_principal)

        buttonPrincipal.setOnClickListener {
            // Cambiar la imagen.
            if (true) {
                imageView.setImageResource(R.mipmap.isaac_maricon_feliz)

                // Iniciar una corutina para esperar 2 segundos antes de cambiar al otro layout.
                GlobalScope.launch {
                    delay(1000)
                    runOnUiThread {
                        setContentView(R.layout.activity_menu)
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
                        val conyo = findViewById<ImageButton>(R.id.isaac_conyo).setOnClickListener(
                            View.OnClickListener {
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
                }
            } else {
                imageView.setImageResource(R.mipmap.isaac_maricon)
            }
        }
    }

    private fun playYPause(idAudio: Int) {
        if (idAudioActual == idAudio) {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
            } else {
//                mediaPlayer?.seekTo(0)
                mediaPlayer?.start()
            }
        } else {
            // If a different audio is selected, stop the current and start the new one
            mediaPlayer?.stop()
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(this, idAudio)
            mediaPlayer?.start()

            idAudioActual = idAudio
        }
    }

    // Limpiar el MediaPLayer cuando se ha acabado con él
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}