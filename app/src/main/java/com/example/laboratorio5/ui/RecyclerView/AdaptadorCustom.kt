package com.example.laboratorio5.ui.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio5.R
import kotlinx.android.synthetic.main.content_item.view.*
import kotlinx.android.synthetic.main.mostrar_resultados_fragment.view.*

class AdaptadorCustom(var items: ArrayList<Objeto>): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {

    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista) {


        fun binditem(data: Objeto) {
            val tittle: TextView = itemView.findViewById(R.id.viewText)
            val imagen: ImageView = itemView.findViewById(R.id.viewIcon)
            tittle.text = data.contenido
            imagen.setImageResource(data.icono)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.content_item, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditem(items[position])
    }


}