package com.example.momentoisaac

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPrincipal: Button = findViewById(R.id.principal)
        val imageView: ImageView = findViewById(R.id.imagen_principal)

        buttonPrincipal.setOnClickListener {
            // Cambiar la imagen.
            val hahaha = true
            if (hahaha) {
                imageView.setImageResource(R.mipmap.isaac_maricon_feliz)

                // Iniciar una corutina para esperar 2 segundos antes de cambiar al otro layout.
                GlobalScope.launch {
                    delay(1000)
                    runOnUiThread {
                        setContentView(R.layout.activity_menu)
                    }
                }
            } else {
                imageView.setImageResource(R.mipmap.isaac_maricon)
            }
        }
    }
}