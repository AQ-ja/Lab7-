package com.example.laboratorio5.ui.AddQuestion

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.laboratorio5.MainActivity
import com.example.laboratorio5.databinding.AddQuestionFragmentBinding
import com.example.laboratorio5.R
import com.example.laboratorio5.SharedView
import com.example.laboratorio5.ui.db.AppDatabase
import com.example.laboratorio5.ui.db.DataBase

import com.example.laboratorio5.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.add_question_fragment.*
import kotlin.concurrent.thread

class addQuestion : Fragment() , View.OnClickListener{


    private val HomeUriModel by lazy {
        ViewModelProviders.of(activity!!).get(SharedView::class.java)
    }

    //val spinner = databinding.spinner
    lateinit var databinding: AddQuestionFragmentBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    private lateinit var viewModel: AddQuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        databinding = DataBindingUtil.inflate(inflater, R.layout.add_question_fragment, container, false)
        val spinner = databinding.spinner
        val adapter = activity?.let { ArrayAdapter.createFromResource(it, R.array.city_list, android.R.layout.simple_spinner_item) }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        return databinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddQuestionViewModel::class.java)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        (activity as MainActivity).supportActionBar?.title = "Add question"

    }



    override fun onClick(v: View?) {

    }
    //Esto es para mostrar el toolbar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.guardar,menu);
        super.onCreateOptionsMenu(menu, inflater)
    }
    //Se le da la accion de ir a el fragment de la biografia cuando apacha el boton del toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId;
        if (id == R.id.guardar){
            if(!TextUtils.isEmpty(preguntaAdd.text.toString())){
                HomeUriModel.mutableList.add(preguntaAdd.text.toString())
                HomeUriModel.tipoList.add(spinner.selectedItem.toString())
                Toast.makeText(activity!!.applicationContext, "Tu pregunta se ha guardado exitosamente", Toast.LENGTH_LONG).show()
                navController.navigate(R.id.action_addQuestion_to_nav_home)
                thread {
                    val db = Room.databaseBuilder(
                        activity!!.applicationContext,
                        AppDatabase::class.java, "ULTIMO").build()
                    val a = db.userDao().getAll()
                    db.userDao().insertAll(DataBase(id = a.size+1, tipo = spinner.selectedItem.toString(), pregunta = preguntaAdd.text.toString(), defaul = false))
                    db.close()
                }


            }
        }
        return super.onOptionsItemSelected(item)
    }




}
