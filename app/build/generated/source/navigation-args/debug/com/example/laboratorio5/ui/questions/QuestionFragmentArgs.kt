package com.example.laboratorio5.ui.questions

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Array
import kotlin.String
import kotlin.jvm.JvmStatic

data class QuestionFragmentArgs(
  val Lista: Array<String>
) : NavArgs {
  fun toBundle(): Bundle {
    val result = Bundle()
    result.putStringArray("Lista", this.Lista)
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): QuestionFragmentArgs {
      bundle.setClassLoader(QuestionFragmentArgs::class.java.classLoader)
      val __Lista : Array<String>?
      if (bundle.containsKey("Lista")) {
        __Lista = bundle.getStringArray("Lista")
        if (__Lista == null) {
          throw IllegalArgumentException("Argument \"Lista\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"Lista\" is missing and does not have an android:defaultValue")
      }
      return QuestionFragmentArgs(__Lista)
    }
  }
}
