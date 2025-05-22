package com.negabytes.introkotlin_901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.negabytes.introkotlin_901.cinepolis.CinepolisActivity
import com.negabytes.introkotlin_901.ejemplo1.SumaActivity
import com.negabytes.introkotlin_901.ejemplo2.Resultado

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        // Configurar edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Botón para Ejemplo1 (Suma)
        findViewById<Button>(R.id.btn1).setOnClickListener {
            navigateToSuma()
        }

        // Botón para Cinepolis
        findViewById<Button>(R.id.btn2).setOnClickListener {
            navigateToCinepolis()
        }


        // Botón para Saludo
        findViewById<Button>(R.id.btn3).setOnClickListener {
            navigateToSaludo()
        }
    }

    private fun navigateToSuma() {
        val intent = Intent(this, SumaActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToCinepolis() {
        val intent = Intent(this, CinepolisActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludo() {
        val intent = Intent(this, Resultado::class.java)
        startActivity(intent)
    }
}