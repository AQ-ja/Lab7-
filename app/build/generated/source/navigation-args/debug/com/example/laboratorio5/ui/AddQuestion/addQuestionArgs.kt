package com.example.laboratorio5.ui.AddQuestion

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Array
import kotlin.String
import kotlin.jvm.JvmStatic

data class addQuestionArgs(
  val lista1: Array<String>
) : NavArgs {
  fun toBundle(): Bundle {
    val result = Bundle()
    result.putStringArray("lista1", this.lista1)
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): addQuestionArgs {
      bundle.setClassLoader(addQuestionArgs::class.java.classLoader)
      val __lista1 : Array<String>?
      if (bundle.containsKey("lista1")) {
        __lista1 = bundle.getStringArray("lista1")
        if (__lista1 == null) {
          throw IllegalArgumentException("Argument \"lista1\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"lista1\" is missing and does not have an android:defaultValue")
      }
      return addQuestionArgs(__lista1)
    }
  }
}
