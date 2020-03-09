package com.example.laboratorio5.ui.questions

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.laboratorio5.R

class QuestionFragmentDirections private constructor() {
  companion object {
    fun actionQuestionFragmentToResultadosFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_questionFragment_to_resultadosFragment)
  }
}
