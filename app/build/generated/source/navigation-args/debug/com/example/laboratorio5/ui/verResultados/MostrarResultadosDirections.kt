package com.example.laboratorio5.ui.verResultados

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.laboratorio5.R

class MostrarResultadosDirections private constructor() {
  companion object {
    fun actionMostrarResultadosToResultadosFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mostrarResultados_to_resultadosFragment)
  }
}
