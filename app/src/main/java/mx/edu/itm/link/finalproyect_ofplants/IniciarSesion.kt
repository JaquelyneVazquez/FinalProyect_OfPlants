package mx.edu.itm.link.finalproyect_ofplants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import mx.edu.itm.link.finalproyect_ofplants.Utils.MyUtils
import mx.edu.itm.link.finalproyect_ofplants.databinding.ActivityIniciarSesionBinding
import mx.edu.itm.link.finalproyect_ofplants.models.Usuario

class IniciarSesion : AppCompatActivity() {

    private lateinit var binding: ActivityIniciarSesionBinding

    lateinit var editTextCorreo: EditText
    lateinit var editTextPassword: EditText
    lateinit var btnAcceder: Button

    companion object {
        lateinit var logUsuario: Usuario
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_iniciar_sesion)

        val database = MyUtils.dataBaseSQL

        binding = ActivityIniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //database.altaUsuario(Usuario(1, "jaquelyne@gmail.com", "123", "Jaquelyne Vazquez", "4432000000"))

        editTextCorreo = findViewById(R.id.loginEditTextCorreo)
        editTextPassword = findViewById(R.id.loginEditTextPassword)
        btnAcceder = findViewById(R.id.loginBtn)

        btnAcceder.setOnClickListener {
            //val intent = Intent(this, MenuActivity::class.java)
            //startActivity(intent)

            val correo = editTextCorreo.text.toString()
            val password = editTextPassword.text.toString()

            var acceso = false
            for (i in database.consultaUsuarios()){
                if (i.correo.equals(correo.trim())){
                    acceso = true
                    if (i.password.trim().equals(password.trim())){
                        Toast.makeText(this, "Usuario loguedo", Toast.LENGTH_LONG).show()
                         logUsuario = i

                        val intent = Intent(this, MenuActivity::class.java)
                        intent.putExtra("USUARIO", i)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show()
                    }
                }
            }

            if (!acceso){
                Toast.makeText(this, "Verifica tus datos ingresados", Toast.LENGTH_LONG).show()
            }
        }
        }
    }

