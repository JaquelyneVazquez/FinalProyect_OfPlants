package mx.edu.itm.link.finalproyect_ofplants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.activityViewModels
import com.google.gson.Gson
import mx.edu.itm.link.finalproyect_ofplants.Utils.MyUtils
import mx.edu.itm.link.finalproyect_ofplants.databinding.ActivityIniciarSesionBinding
import mx.edu.itm.link.finalproyect_ofplants.models.LocalDBManager
import mx.edu.itm.link.finalproyect_ofplants.models.Usuario
import mx.edu.itm.link.finalproyect_ofplants.ui.GlobalViewModel
import mx.edu.itm.link.finalproyect_ofplants.ui.Profile
import org.json.JSONObject
import www.sanju.motiontoast.MotionToast
import kotlin.math.log

class IniciarSesion : AppCompatActivity() {

    private lateinit var editTextCorreo: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var btnAcceder: Button

    companion object {
        lateinit var usuarioLogueado: Usuario
        lateinit var dbLocal: LocalDBManager
    }

    //private  val viewModel: GlobalViewModel by viewModels()
    val viewModel: GlobalViewModel by viewModels()

    //private lateinit var binding: ActivityIniciarSesionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)
        //----binding = ActivityIniciarSesionBinding.inflate(layoutInflater)
        //---setContentView(binding.root)

        //---val database = MyUtils.dataBaseSQL

        //---dbLocal = LocalDBManager(this, "plantas", null, 1)
        //database.altaUsuario(Usuario(1, "jaquelyne@gmail.com", "123", "Jaquelyne Vazquez", "4432000000"))


        editTextCorreo = findViewById(R.id.loginEditTextCorreo)
        editTextPassword = findViewById(R.id.loginEditTextPassword)
        btnAcceder = findViewById(R.id.loginBtn)


        btnAcceder.setOnClickListener {
            //val intent = Intent(this, MenuActivity::class.java)
            //startActivity(intent)

            var correcto = true
            if (editTextCorreo.text.isEmpty()){
                editTextCorreo.setError("El usuario no debe ser vacio")
                correcto = false
            }
            if (!editTextCorreo.text.contains("@") || !editTextCorreo.text.contains(".") || editTextCorreo.text.length < 5){
                editTextCorreo.error = "El correo es invalido"
                correcto = false
            }
            if(editTextPassword.text.isEmpty()) {
                editTextPassword.setError("La contraseña no debe ser vacía")
                correcto = false
            }
            if(editTextPassword.text.length < 2) {
                editTextPassword.error = "La contraseña es ivalida"
                correcto = false
            }
            if(correcto) {
                login(editTextCorreo.text.toString(), editTextPassword.text.toString())
            }


            /*val correo = editTextCorreo.text.toString()
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
            }*/
        }

    }

    private fun login(usr: String, pass: String) {
        val url = "${resources.getString(R.string.apiusuario)}encuentra.php"
        Log.d("URL",url)

        val params = HashMap<String,String>()
        params.put("usr", usr)
        params.put("pass", pass)

        object : MyUtils() {
            override fun formatResponse(response: String) {
                Log.i("Consume", response)
                try {
                    val json = JSONObject(response)
                    val output = json.getJSONArray("output")

                    val gson = Gson()
                    val usuario = gson.fromJson(output.getJSONObject(0).toString(), Usuario::class.java)

                    usuarioLogueado = usuario

                    val intent = Intent(this@IniciarSesion, MenuActivity::class.java)
                    intent.putExtra("usuario", usuario)
                    startActivity(intent)
                    finish()

                } catch (e: Exception) {
                    Log.e("FR", "Error:\n$e")
                    MotionToast.createToast(
                        this@IniciarSesion,
                        "Error ☹️",
                        "No se encuentra el usuario",
                        MotionToast.TOAST_ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this@IniciarSesion,R.font.helvetica_regular)
                    )
                    "No se pudo conectar, intente mas tarde".toast(this@IniciarSesion)
                }
            }
        }.consumePost(this, url, params)
    }


}

