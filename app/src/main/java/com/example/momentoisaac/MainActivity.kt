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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private var idAudioActual: Int? = null
    private val imgReproduciendo: Int = R.mipmap.isaac_play_foreground
    private val imgPausa: Int = R.mipmap.isaac_pause_foreground
    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonPrincipal: Button = findViewById(R.id.principal)
        val imagenPrincipal: ImageView = findViewById(R.id.imagen_principal)

        botonPrincipal.setOnClickListener {
            // Cambiar la imagen.
            imagenPrincipal.setImageResource(R.mipmap.isaac_maricon_feliz)

            // Iniciar una corutina para esperar 2 segundos antes de cambiar al otro layout.
            GlobalScope.launch {
                delay(1000)
                runOnUiThread {
                    setContentView(R.layout.activity_menu)
                    // Crear los eventos de click para cada uno de los botones
                    // TODO -> Esto es un trabajo muy burdo y simple, no escalable: Pendiente de mejorar
                    val carinyosas = findViewById<ImageButton>(R.id.isaac_carinyosas)
                    carinyosas.setOnClickListener(View.OnClickListener {

                        val audioFilePath = R.raw.carinyosas
                        playYPause(audioFilePath, carinyosas)
                    })
                    val cabezon = findViewById<ImageButton>(R.id.isaac_cabezon)
                    cabezon.setOnClickListener(View.OnClickListener {
                        val audioFilePath = R.raw.eresuncabezon
                        playYPause(audioFilePath, cabezon)
                    })
                    val masculinidad = findViewById<ImageButton>(R.id.isaac_masculinidad)
                    masculinidad.setOnClickListener(View.OnClickListener {
                        val audioFilePath = R.raw.masculinidadfrajil
                        playYPause(audioFilePath, masculinidad)
                    })
                    val conyo = findViewById<ImageButton>(R.id.isaac_conyo)
                    conyo.setOnClickListener(
                        View.OnClickListener {
                        val audioFilePath = R.raw.queconyoestasdiciendo
                        playYPause(audioFilePath, conyo)
                    })
                    val chupas = findViewById<ImageButton>(R.id.isaac_chupas)
                    chupas.setOnClickListener(View.OnClickListener {
                        val audioFilePath = R.raw.simelachupasunrato
                        playYPause(audioFilePath, chupas)
                    })
                    val todas = findViewById<ImageButton>(R.id.isaac_putas)
                    todas.setOnClickListener(View.OnClickListener {
                        val audioFilePath = R.raw.todasputas
                        playYPause(audioFilePath, todas)
                    })
                    val tio = findViewById<ImageButton>(R.id.isaac_tio)
                    tio.setOnClickListener(View.OnClickListener {
                        val audioFilePath = R.raw.vationo
                        playYPause(audioFilePath, tio)
                    })
                    val bandido = findViewById<ImageButton>(R.id.isaac_bandido)
                    bandido.setOnClickListener(View.OnClickListener {
                        val audioFilePath = R.raw.yanosoyunbandido
                        playYPause(audioFilePath, bandido)
                    })
                }
            }
        }
    }

    private fun playYPause(idAudio: Int, btn: ImageButton) {
        if (idAudioActual == idAudio) {
            if (mediaPlayer?.isPlaying == true) {
                btn.setImageResource(R.mipmap.isaac_play_foreground)
                mediaPlayer?.pause()
            } else {
//                mediaPlayer?.seekTo(0)
                btn.setImageResource(R.mipmap.isaac_pause_foreground)
                mediaPlayer?.start()
            }
        } else {
            // If a different audio is selected, stop the current and start the new one
            btn.setImageResource(R.mipmap.isaac_play_foreground)
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