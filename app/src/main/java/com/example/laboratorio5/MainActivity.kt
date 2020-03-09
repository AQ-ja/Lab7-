package com.example.laboratorio5
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.laboratorio5.ui.db.AppDatabase
import com.example.laboratorio5.ui.db.DataBase
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val HomeUriModel = ViewModelProvider(this).get(SharedView::class.java)
        thread {
            try {
                val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "ULTIMO"
                ).build()
                val h = db.userDao()
                val preguntas = db.userDao().getAll()
                HomeUriModel.mutableList.clear()
                HomeUriModel.tipoList.clear()
                if (preguntas.isNotEmpty()) {
                    while (HomeUriModel.contadorAgregarPregunta != preguntas.size) {
                        HomeUriModel.mutableList.add(preguntas[HomeUriModel.contadorAgregarPregunta].pregunta)
                        HomeUriModel.tipoList.add(preguntas[HomeUriModel.contadorAgregarPregunta].tipo)
                        HomeUriModel.contadorAgregarPregunta++
                    }
                    HomeUriModel.contadorAgregarPregunta = 0
                }
                val a = db.encuesta().getAll()
                HomeUriModel.encuestaVeces = a.size
            } catch (e: Exception) {
                val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "ULTIMO"
                ).build()
                Log.d("DONALDO", "Error")
                db.clearAllTables()
                db.userDao().insertAll(DataBase(id = 1,tipo = "String", pregunta = "¿Tiene algún comentario o sugerencia?", defaul = true))
                db.userDao().insertAll(DataBase(id = 2,tipo = "Rating", pregunta = "¿Qué le pareció nuestro servicio?", defaul = true))
                val a = db.userDao().getAll()
                HomeUriModel.mutableList.add(a[0].pregunta)
                HomeUriModel.tipoList.add(a[0].tipo)
                HomeUriModel.mutableList.add(a[1].pregunta)
                HomeUriModel.tipoList.add(a[1].tipo)
                val b = db.encuesta().getAll()
                HomeUriModel.encuestaVeces = b.size
                db.close()
            }
        }


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_About
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
