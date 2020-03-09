package com.example.laboratorio5.ui.verResultados

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.laboratorio5.R
import com.example.laboratorio5.SharedView
import com.example.laboratorio5.ui.RecyclerView.AdaptadorCustom
import com.example.laboratorio5.ui.RecyclerView.Objeto
import com.example.laboratorio5.ui.db.AppDatabase

import kotlin.concurrent.thread


class MostrarResultados : Fragment(), View.OnClickListener{
    var rating: Double = 1.0
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var objeto: ArrayList<Objeto>
    private val SharedView by lazy {
        ViewModelProviders.of(activity!!).get(SharedView::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private lateinit var viewModel: MostrarResultadosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.mostrar_resultados_fragment, container, false)
        objeto = ArrayList<Objeto>()
        thread {
            val db = Room.databaseBuilder(
                activity!!.applicationContext,
                AppDatabase::class.java, "ULTIMO"
            ).build()
            val respuestas = db.respuesta().getAll()
            val encuestas = db.encuesta().getAll()
            val dao = db.userDao().getAll()
            try {
                while (SharedView.contadorResultados != encuestas.size){
                    val ids = db.respuesta().findid(SharedView.contadorResultados+1)
                    SharedView.encuestaNum = encuestas[SharedView.contadorResultados].fecha_creacion
                    while (SharedView.contadorResultadosInner != ids.size) {
                        SharedView.RESPUESTAFINAL = SharedView.encuestaNum + "\n ${SharedView.mutableList[ids[SharedView.contadorResultadosInner].question_id-1]} : ${ids[SharedView.contadorResultadosInner].answer}"
                        while(SharedView.contadorImagen != 1){
                            var h = ids[SharedView.contadorLlevaCuenta].question_id
                            if(h == 2){
                                rating = ids[SharedView.contadorLlevaCuenta].answer.toDouble()
                                SharedView.contadorImagen++
                            }
                            SharedView.contadorLlevaCuenta++
                        }
                        when(rating){
                            1.0 -> objeto.add(Objeto(SharedView.RESPUESTAFINAL, R.drawable.estrella1))
                            2.0 -> objeto.add(Objeto(SharedView.RESPUESTAFINAL, R.drawable.estrella2))
                            3.0 -> objeto.add(Objeto(SharedView.RESPUESTAFINAL, R.drawable.estrella3))
                            4.0 -> objeto.add(Objeto(SharedView.RESPUESTAFINAL, R.drawable.estrella4))
                            else -> objeto.add(Objeto(SharedView.RESPUESTAFINAL, R.drawable.estrella5))
                        }
                        SharedView.contadorImagen = 0
                        SharedView.contadorLlevaCuenta = 0
                        SharedView.RESPUESTAFINAL = ""
                        SharedView.contadorResultadosInner++
                    }
                    SharedView.encuestaNum = ""
                    SharedView.contadorResultadosInner = 0
                    SharedView.contadorResultados++

                }
                db.close()
                SharedView.contadorResultados = 0

                viewAdapter = AdaptadorCustom(objeto)
                recyclerView = root.findViewById(R.id.lista)
                viewManager = LinearLayoutManager(activity)
                recyclerView.layoutManager = viewManager
                recyclerView.adapter = viewAdapter
                recyclerView.setHasFixedSize(true)
                viewAdapter = AdaptadorCustom(objeto)
                recyclerView.adapter = viewAdapter
            }catch (e: Exception){
                Log.d("DONALDO", "SE PETOO :(")
                viewAdapter = AdaptadorCustom(objeto)
                recyclerView = root.findViewById(R.id.lista)
                viewManager = LinearLayoutManager(activity)
                recyclerView.layoutManager = viewManager
                recyclerView.adapter = viewAdapter
                recyclerView.setHasFixedSize(true)
                viewAdapter = AdaptadorCustom(objeto)
                recyclerView.adapter = viewAdapter

            }
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MostrarResultadosViewModel::class.java)
        // TODO: Use the ViewModel
    }


    override fun onClick(v: View?) {
    }

}

