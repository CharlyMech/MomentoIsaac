package com.example.momentoisaac

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Segun si se ha pulsado el botón, cambiará permanentemente la imagen o no.

        val buttonPrincipal: Button = findViewById(R.id.principal)
        val imageView: ImageView = findViewById(R.id.imagen_principal)
        buttonPrincipal.setOnClickListener{
            val imagenCambiada = true
            if (imagenCambiada) {
                imageView.setImageResource(R.mipmap.isaac_maricon_feliz)
            } else {
                imageView.setImageResource(R.mipmap.isaac_maricon)
            }
        }
    }
}