package com.example.laboratorio5.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.room.Room
import com.example.laboratorio5.MainActivity
import com.example.laboratorio5.R
import com.example.laboratorio5.SharedView
import com.example.laboratorio5.databinding.FragmentHomeBinding
import com.example.laboratorio5.ui.db.AppDatabase
import com.example.laboratorio5.ui.dbEncuesta.DataBaseEncuesta
import com.example.laboratorio5.ui.questions.QuestionFragment
import com.example.laboratorio5.ui.questions.QuestionViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.concurrent.thread

class HomeFragment : Fragment(), View.OnClickListener{
    private val SharedView by lazy {
        ViewModelProviders.of(activity!!).get(SharedView::class.java)
    }
    lateinit var navController: NavController
    private lateinit var homeViewModel: HomeViewModel
    lateinit var binding : FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.iniciarencuesta.setOnClickListener {
            SharedView.contador = 1
            SharedView.RESPUESTAFINAL = ""
            SharedView.contadorParaPreguntas = 2
            SharedView.contadorFinal = 0
            SharedView.encuestaVeces++
            SharedView.listaQuestionid.clear()
            SharedView.respuestaId.clear()
            thread {
                val db = Room.databaseBuilder(
                    activity!!.applicationContext,
                    AppDatabase::class.java, "ULTIMO"
                ).build()
                val a = db.encuesta().getAll()
                db.encuesta().insertAll(DataBaseEncuesta(id = a.size+1, fecha_creacion = "Encuesta ${SharedView.encuestaVeces}"))
                db.close()
            }
            SharedView.visibility = View.INVISIBLE
            navController.navigate(R.id.action_nav_home_to_questionFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.fab -> {
                navController.navigate(R.id.action_nav_home_to_addQuestion)

            }
        }

    }


}