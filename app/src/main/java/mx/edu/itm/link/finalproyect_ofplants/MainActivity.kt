package mx.edu.itm.link.finalproyect_ofplants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import mx.edu.itm.link.finalproyect_ofplants.Utils.MyUtils
import mx.edu.itm.link.finalproyect_ofplants.models.LocalDBManager

class MainActivity : AppCompatActivity() {

    lateinit var btnIniciarSesion : Button
    lateinit var btnRegistrarse : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyUtils.dataBaseSQL = LocalDBManager(this, "BD", null, 1)
        /*var dbLocal = LocalDBManager(this, "BD", null, 1)
        val usuarios = dbLocal.consultaUsuarios()*/

        btnIniciarSesion = findViewById(R.id.btnInicioAccederLogin)

        btnIniciarSesion.setOnClickListener {
            val intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }
    }
}