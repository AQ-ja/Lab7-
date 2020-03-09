package com.example.laboratorio5.ui.AddQuestion

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.laboratorio5.R
import kotlin.Array
import kotlin.Int
import kotlin.String

class addQuestionDirections private constructor() {
  private data class ActionAddQuestionToQuestionFragment(
    val Lista: Array<String>
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_addQuestion_to_questionFragment

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putStringArray("Lista", this.Lista)
      return result
    }
  }

  companion object {
    fun actionAddQuestionToNavHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addQuestion_to_nav_home)

    fun actionAddQuestionToQuestionFragment(Lista: Array<String>): NavDirections =
        ActionAddQuestionToQuestionFragment(Lista)
  }
}
