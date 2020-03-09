package com.example.laboratorio5
import android.net.Uri
import android.opengl.Visibility
import android.view.View
import android.widget.RatingBar

import androidx.lifecycle.ViewModel

class SharedView: ViewModel() {
    var mutableList: MutableList<String> = mutableListOf()
    var respuestaId: MutableList<String> = mutableListOf()
    var listaQuestionid: MutableList<Int> = mutableListOf()
    var resultados: String = ""
    var rating: String = ""
    var encuestaVeces: Int = 0
    var contador: Int = 1
    var visibility: Int = 0
    var tipoList: MutableList<String> = mutableListOf()
    var contadorParaPreguntas: Int = 2
    var contadorFinal: Int = 0
    var contadorAgregarPregunta: Int = 0
    var contadorResultados: Int = 0
    var RESPUESTAFINAL: String = ""
    var contadorResultadosInner: Int = 0
    var encuestaNum: String = ""
    var contadorImagen: Int = 0
    var contadorLlevaCuenta: Int = 0

}