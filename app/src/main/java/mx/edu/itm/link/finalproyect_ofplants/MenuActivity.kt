package mx.edu.itm.link.finalproyect_ofplants

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import mx.edu.itm.link.finalproyect_ofplants.databinding.ActivityMenuBinding
import mx.edu.itm.link.finalproyect_ofplants.models.Usuario
import mx.edu.itm.link.finalproyect_ofplants.ui.GlobalViewModel
import www.sanju.motiontoast.MotionToast

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    private lateinit var usuario: Usuario
    private val viewModel: GlobalViewModel by viewModels()

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        usuario = intent.getSerializableExtra("usuario") as Usuario


        MotionToast.createToast(
            this,
            "¡Hola ${usuario.nombre} bienvenido!",
            "Ahora puedes visualizar los distintos tipos de plantas.",
            MotionToast.TOAST_SUCCESS,
            MotionToast.GRAVITY_CENTER,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(this,R.font.helvetica_regular)
        )

        val navController = findNavController(R.id.nav_host_fragment_activity_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_buy, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        supportActionBar?.let {
            it.setDefaultDisplayHomeAsUpEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}