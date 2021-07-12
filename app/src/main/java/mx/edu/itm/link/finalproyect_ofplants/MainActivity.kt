package mx.edu.itm.link.finalproyect_ofplants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnIniciarSesion : Button
    lateinit var btnRegistrarse : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIniciarSesion = findViewById(R.id.btnInicioAccederLogin)

        btnIniciarSesion.setOnClickListener {
            val intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }
    }
}