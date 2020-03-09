package com.example.laboratorio5.ui.questions

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.laboratorio5.MainActivity

import com.example.laboratorio5.R
import com.example.laboratorio5.SharedView
import com.example.laboratorio5.databinding.QuestionFragmentBinding
import com.example.laboratorio5.ui.db.AppDatabase
import com.example.laboratorio5.ui.db.DataBase
import com.example.laboratorio5.ui.dbEncuesta.DataBaseEncuesta
import com.example.laboratorio5.ui.dbRespuesta.DataBaseRespuesta
import com.example.laboratorio5.ui.home.HomeViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.add_question_fragment.*
import kotlinx.android.synthetic.main.question_fragment.*
import kotlin.Exception
import kotlin.concurrent.thread

class QuestionFragment : Fragment(),View.OnClickListener {

    private val SharedView by lazy {
        ViewModelProviders.of(activity!!).get(SharedView::class.java)
    }
    lateinit var databinding: QuestionFragmentBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding = DataBindingUtil.inflate(inflater, R.layout.question_fragment, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next).setOnClickListener(this)

        if(SharedView.contadorParaPreguntas < SharedView.mutableList.size){
            if (SharedView.tipoList[SharedView.contadorParaPreguntas] == "Rating") {
                preguntaShow.text =
                    SharedView.mutableList[SharedView.contadorParaPreguntas]
                (activity as MainActivity).supportActionBar!!.title =
                    "Survey app(${SharedView.contador}/${SharedView.mutableList.size})"
                databinding.ratingBar.visibility = View.VISIBLE
                databinding.respuesta.visibility = View.INVISIBLE

            } else {
                databinding.ratingBar.visibility = View.INVISIBLE
                databinding.respuesta.visibility = View.VISIBLE
                preguntaShow.text =
                    SharedView.mutableList[SharedView.contadorParaPreguntas]
                (activity as MainActivity).supportActionBar!!.title =
                    "Survey app(${SharedView.contador}/${SharedView.mutableList.size})"

            }
        }else{
            if (SharedView.tipoList[SharedView.contadorFinal] == "Rating") {
                preguntaShow.text = SharedView.mutableList[1]
                (activity as MainActivity).supportActionBar!!.title = "Survey app(${SharedView.contador}/${SharedView.mutableList.size})"
                databinding.ratingBar.visibility = View.VISIBLE
                databinding.respuesta.visibility = View.INVISIBLE

            } else {
                databinding.ratingBar.visibility = View.INVISIBLE
                databinding.respuesta.visibility = View.VISIBLE
                preguntaShow.text = SharedView.mutableList[0]
                (activity as MainActivity).supportActionBar!!.title = "Survey app(${SharedView.contador}/${SharedView.mutableList.size})"
            }
        }

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.next -> {
                if (SharedView.mutableList.size == 2) {
                    SharedView.contadorFinal++
                }
                if (SharedView.contadorParaPreguntas < SharedView.mutableList.size) {

                    try {
                        if (SharedView.tipoList[SharedView.contadorParaPreguntas + 1] == "Rating") {
                            SharedView.listaQuestionid.add(SharedView.contadorParaPreguntas+1)
                            SharedView.respuestaId.add(ratingBar.rating.toString())
                            preguntaShow.text =
                                SharedView.mutableList[SharedView.contadorParaPreguntas + 1]
                            (activity as MainActivity).supportActionBar!!.title =
                                "Survey app(${SharedView.contador + 1}/${SharedView.mutableList.size})"
                            databinding.ratingBar.visibility = View.VISIBLE
                            databinding.respuesta.visibility = View.INVISIBLE
                            //db.respuesta().insertAll(DataBaseRespuesta(id = null, poll_id = SharedView.encuestaVeces, question_id = SharedView.contadorParaPreguntas+1, answer = SharedView.resultados))

                        } else {
                            SharedView.listaQuestionid.add(SharedView.contadorParaPreguntas+1)
                            SharedView.respuestaId.add(respuesta.text.toString())
                            databinding.ratingBar.visibility = View.INVISIBLE
                            databinding.respuesta.visibility = View.VISIBLE
                            preguntaShow.text =
                                SharedView.mutableList[SharedView.contadorParaPreguntas + 1]
                            (activity as MainActivity).supportActionBar!!.title =
                                "Survey app(${SharedView.contador + 1}/${SharedView.mutableList.size})"

                            //db.respuesta().insertAll(DataBaseRespuesta(id = null, poll_id = SharedView.encuestaVeces, question_id = SharedView.contadorParaPreguntas+1, answer = SharedView.resultados))
                        }
                    } catch (e: Exception) {
                        if (SharedView.contadorFinal >= 2) {
                            SharedView.contadorFinal = 0
                        }
                        if (SharedView.tipoList[SharedView.contadorFinal] == "Rating") {
                            SharedView.listaQuestionid.add(1)
                            SharedView.respuestaId.add(respuesta.text.toString())
                            preguntaShow.text = SharedView.mutableList[1]
                            (activity as MainActivity).supportActionBar!!.title =
                                "Survey app(${SharedView.contador + 1}/${SharedView.mutableList.size})"
                            databinding.ratingBar.visibility = View.VISIBLE
                            databinding.respuesta.visibility = View.INVISIBLE

                            //db.respuesta().insertAll(DataBaseRespuesta(id = null, poll_id = SharedView.encuestaVeces, question_id = 2, answer = SharedView.resultados))
                        } else {
                            SharedView.listaQuestionid.add(2)
                            SharedView.respuestaId.add(ratingBar.rating.toString())
                            databinding.ratingBar.visibility = View.INVISIBLE
                            databinding.respuesta.visibility = View.VISIBLE
                            preguntaShow.text = SharedView.mutableList[0]
                            (activity as MainActivity).supportActionBar!!.title =
                                "Survey app(${SharedView.contador + 1}/${SharedView.mutableList.size})"
                            //db.respuesta().insertAll(DataBaseRespuesta(id = null, poll_id = SharedView.encuestaVeces, question_id = 1, answer = SharedView.resultados))
                        }
                        SharedView.contadorFinal++
                    }
                } else {
                    if (SharedView.contadorFinal >= 2) {
                        SharedView.contadorFinal = 0
                    }
                    if (SharedView.tipoList[SharedView.contadorFinal] == "Rating") {
                        SharedView.listaQuestionid.add(1)
                        SharedView.respuestaId.add(respuesta.text.toString())
                        preguntaShow.text = SharedView.mutableList[1]
                        (activity as MainActivity).supportActionBar!!.title = "Survey app(${SharedView.contador + 1}/${SharedView.mutableList.size})"
                        databinding.ratingBar.visibility = View.VISIBLE
                        databinding.respuesta.visibility = View.INVISIBLE

                    } else {
                        SharedView.listaQuestionid.add(2)
                        SharedView.respuestaId.add(ratingBar.rating.toString())
                        databinding.ratingBar.visibility = View.INVISIBLE
                        databinding.respuesta.visibility = View.VISIBLE
                        preguntaShow.text = SharedView.mutableList[0]
                        (activity as MainActivity).supportActionBar!!.title =
                            "Survey app(${SharedView.contador + 1}/${SharedView.mutableList.size})"
                    }
                    SharedView.contadorFinal++
                }
                if(SharedView.listaQuestionid[0] == 2){
                    SharedView.listaQuestionid[0] = 3
                    if(SharedView.tipoList[0] == "Rating"){
                        SharedView.respuestaId[0] = ratingBar.rating.toString()
                    }else{
                        SharedView.respuestaId[0] = respuesta.text.toString()
                    }
                }
                if (SharedView.mutableList.size <= SharedView.contador) {
                    thread {
                        //                            SharedView.respuestaId.removeAt(SharedView.respuestaId.size-1)
//                            SharedView.listaQuestionid.removeAt(SharedView.listaQuestionid.size-1)

                        val db = Room.databaseBuilder(
                            activity!!.applicationContext,
                            AppDatabase::class.java, "ULTIMO"
                        ).build()
                        while (SharedView.contadorAgregarPregunta != SharedView.respuestaId.size) {
                            db.respuesta().insertAll(
                                DataBaseRespuesta(
                                    id = null,
                                    answer = SharedView.respuestaId[SharedView.contadorAgregarPregunta],
                                    poll_id = SharedView.encuestaVeces,
                                    question_id = SharedView.listaQuestionid[SharedView.contadorAgregarPregunta]
                                )
                            )
                            SharedView.contadorAgregarPregunta++
                        }
                        SharedView.rating = SharedView.respuestaId[SharedView.respuestaId.lastIndex]
                        SharedView.listaQuestionid.clear()
                        SharedView.respuestaId.clear()
                        SharedView.contadorAgregarPregunta = 0
                    }
                    SharedView.contador = 1
                    SharedView.contadorFinal = 0
                    SharedView.contadorParaPreguntas = 2
                    navController.navigate(R.id.action_questionFragment_to_resultadosFragment)
                }
                SharedView.contador++
                SharedView.contadorParaPreguntas++
            }
        }
    }
}



