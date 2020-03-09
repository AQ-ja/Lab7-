package com.example.laboratorio5.ui.Resultados

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.room.Room
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.laboratorio5.MainActivity

import com.example.laboratorio5.R
import com.example.laboratorio5.SharedView
import com.example.laboratorio5.databinding.ResultadosFragmentBinding
import com.example.laboratorio5.ui.db.AppDatabase
import com.example.laboratorio5.ui.db.DataBase
import com.example.laboratorio5.ui.dbEncuesta.DataBaseEncuesta
import com.example.laboratorio5.ui.dbRespuesta.DataBaseRespuesta
import kotlinx.android.synthetic.main.add_question_fragment.*
import kotlinx.android.synthetic.main.question_fragment.*
import kotlin.concurrent.thread

class ResultadosFragment : Fragment(), View.OnClickListener{
    lateinit var databinding: ResultadosFragmentBinding
    lateinit var navController: NavController

    private val SharedView by lazy {
        ViewModelProviders.of(activity!!).get(SharedView::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding = DataBindingUtil.inflate(inflater, R.layout.resultados_fragment, container, false)
        SharedView.contadorAgregarPregunta = 0
        databinding.nuevaEncuesta.setOnClickListener {
            SharedView.contador = 1
            SharedView.RESPUESTAFINAL = ""
            SharedView.listaQuestionid.clear()
            SharedView.respuestaId.clear()
            SharedView.encuestaVeces++
            thread {
                val db = Room.databaseBuilder(
                    activity!!.applicationContext,
                    AppDatabase::class.java, "ULTIMO"
                ).build()
                val a = db.encuesta().getAll()
                db.encuesta().insertAll(DataBaseEncuesta(id = a.size+1, fecha_creacion = "Encuesta ${SharedView.encuestaVeces}"))
                db.close()
            }
            SharedView.contadorParaPreguntas = 2
            SharedView.visibility = View.INVISIBLE
            navController.navigate(R.id.action_resultadosFragment_to_questionFragment)
        }
        databinding.respuestasVer.setOnClickListener {
            navController.navigate(R.id.action_resultadosFragment_to_mostrarResultados)
        }
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        databinding.rating.text = "Rating: " + SharedView.rating
        databinding.encuestasNum.text = "Encuestas: " + SharedView.encuestaVeces.toString()
    }
    override fun onClick(v: View?) {

    }
    //Esto es para mostrar el toolbar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.agregar,menu);
        super.onCreateOptionsMenu(menu, inflater)
    }
    //Se le da la accion de ir a el fragment de la biografia cuando apacha el boton del toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId;
        if (id == R.id.eliminar_respuestas){
            thread {
                val db = Room.databaseBuilder(
                    activity!!.applicationContext,
                    AppDatabase::class.java, "ULTIMO").build()
                db.clearAllTables()
                db.userDao().insertAll(DataBase(id = 1,tipo = "String", pregunta = "¿Tiene algún comentario o sugerencia?", defaul = true))
                db.userDao().insertAll(DataBase(id = 2,tipo = "Rating", pregunta = "¿Qué le pareció nuestro servicio?", defaul = true))
                val preguntas = db.userDao().getAll()
                SharedView.mutableList.clear()
                SharedView.tipoList.clear()
                SharedView.encuestaVeces = 0
                if (preguntas.isNotEmpty()) {
                    while (SharedView.contadorAgregarPregunta != preguntas.size) {
                        SharedView.mutableList.add(preguntas[SharedView.contadorAgregarPregunta].pregunta)
                        SharedView.tipoList.add(preguntas[SharedView.contadorAgregarPregunta].tipo)
                        SharedView.contadorAgregarPregunta++
                    }
                    SharedView.contadorAgregarPregunta = 0
                }
                db.close()
            }
        }
        if (id == R.id.eliminar_preguntas){
            thread {
                val db = Room.databaseBuilder(
                    activity!!.applicationContext,
                    AppDatabase::class.java, "ULTIMO").build()
                db.clearAllTables()
                db.userDao().insertAll(DataBase(id = 1,tipo = "String", pregunta = "¿Tiene algún comentario o sugerencia?", defaul = true))
                db.userDao().insertAll(DataBase(id = 2,tipo = "Rating", pregunta = "¿Qué le pareció nuestro servicio?", defaul = true))
                val preguntas = db.userDao().getAll()
                SharedView.mutableList.clear()
                SharedView.tipoList.clear()
                SharedView.encuestaVeces = 0
                if (preguntas.isNotEmpty()) {
                    while (SharedView.contadorAgregarPregunta != preguntas.size) {
                        SharedView.mutableList.add(preguntas[SharedView.contadorAgregarPregunta].pregunta)
                        SharedView.tipoList.add(preguntas[SharedView.contadorAgregarPregunta].tipo)
                        SharedView.contadorAgregarPregunta++
                    }
                    SharedView.contadorAgregarPregunta = 0
                }
                db.close()
            }
        }
        if (id == R.id.eliminar_encuesta){
            thread {
                val db = Room.databaseBuilder(
                    activity!!.applicationContext,
                    AppDatabase::class.java, "ULTIMO").build()
                db.clearAllTables()
                db.userDao().insertAll(DataBase(id = 1,tipo = "String", pregunta = "¿Tiene algún comentario o sugerencia?", defaul = true))
                db.userDao().insertAll(DataBase(id = 2,tipo = "Rating", pregunta = "¿Qué le pareció nuestro servicio?", defaul = true))
                val preguntas = db.userDao().getAll()
                SharedView.mutableList.clear()
                SharedView.tipoList.clear()
                SharedView.encuestaVeces = 0
                if (preguntas.isNotEmpty()) {
                    while (SharedView.contadorAgregarPregunta != preguntas.size) {
                        SharedView.mutableList.add(preguntas[SharedView.contadorAgregarPregunta].pregunta)
                        SharedView.tipoList.add(preguntas[SharedView.contadorAgregarPregunta].tipo)
                        SharedView.contadorAgregarPregunta++
                    }
                    SharedView.contadorAgregarPregunta = 0
                }
                db.close()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
