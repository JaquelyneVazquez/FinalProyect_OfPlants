package mx.edu.itm.link.finalproyect_ofplants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText

class IniciarSesion : AppCompatActivity() {

    lateinit var editTextCorreo : EditText
    lateinit var editTextPassword : EditText
    lateinit var btnAcceder : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        editTextCorreo = findViewById(R.id.loginEditTextCorreo)
        editTextPassword = findViewById(R.id.loginEditTextPassword)
        btnAcceder = findViewById(R.id.loginBtn)

        btnAcceder.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}