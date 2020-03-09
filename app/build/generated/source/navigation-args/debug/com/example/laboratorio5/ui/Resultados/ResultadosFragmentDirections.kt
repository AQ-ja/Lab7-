package com.example.laboratorio5.ui.Resultados

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.laboratorio5.R
import kotlin.Array
import kotlin.Int
import kotlin.String

class ResultadosFragmentDirections private constructor() {
  private data class ActionResultadosFragmentToQuestionFragment(
    val Lista: Array<String>
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_resultadosFragment_to_questionFragment

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putStringArray("Lista", this.Lista)
      return result
    }
  }

  companion object {
    fun actionResultadosFragmentToQuestionFragment(Lista: Array<String>): NavDirections =
        ActionResultadosFragmentToQuestionFragment(Lista)

    fun actionResultadosFragmentToMostrarResultados(): NavDirections =
        ActionOnlyNavDirections(R.id.action_resultadosFragment_to_mostrarResultados)
  }
}
