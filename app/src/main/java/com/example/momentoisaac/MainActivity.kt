package com.example.momentoisaac

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPrincipal: Button = findViewById(R.id.principal)
        val imageView: ImageView = findViewById(R.id.imagen_principal)
        buttonPrincipal.setOnClickListener(View.OnClickListener {
            // Verificar el estado de la imagen y cambiarla en función de eso
            var imagenCambiada = true
            if (imagenCambiada) {
                imageView.setImageResource(R.mipmap.isaac_maricon_feliz)
                imagenCambiada = true
            } else {
                imageView.setImageResource(R.mipmap.isaac_maricon)
                imagenCambiada = false
            }
        })
    }
}