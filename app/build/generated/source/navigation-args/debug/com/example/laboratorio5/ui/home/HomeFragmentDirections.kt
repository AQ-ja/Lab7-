package com.example.laboratorio5.ui.home

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.laboratorio5.R
import kotlin.Array
import kotlin.Int
import kotlin.String

class HomeFragmentDirections private constructor() {
  private data class ActionNavHomeToAddQuestion(
    val lista1: Array<String>
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_nav_home_to_addQuestion

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putStringArray("lista1", this.lista1)
      return result
    }
  }

  private data class ActionNavHomeToQuestionFragment(
    val Lista: Array<String>
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_nav_home_to_questionFragment

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putStringArray("Lista", this.Lista)
      return result
    }
  }

  companion object {
    fun actionNavHomeToNavAbout(): NavDirections =
        ActionOnlyNavDirections(R.id.action_nav_home_to_nav_About)

    fun actionNavHomeToAddQuestion(lista1: Array<String>): NavDirections =
        ActionNavHomeToAddQuestion(lista1)

    fun actionNavHomeToQuestionFragment(Lista: Array<String>): NavDirections =
        ActionNavHomeToQuestionFragment(Lista)

    fun actionNavHomeToResultadosFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_nav_home_to_resultadosFragment)
  }
}
