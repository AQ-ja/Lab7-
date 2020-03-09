package com.example.laboratorio5;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.laboratorio5.databinding.AddQuestionFragmentBindingImpl;
import com.example.laboratorio5.databinding.FragmentHomeBindingImpl;
import com.example.laboratorio5.databinding.QuestionFragmentBindingImpl;
import com.example.laboratorio5.databinding.ResultadosFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ADDQUESTIONFRAGMENT = 1;

  private static final int LAYOUT_FRAGMENTHOME = 2;

  private static final int LAYOUT_QUESTIONFRAGMENT = 3;

  private static final int LAYOUT_RESULTADOSFRAGMENT = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.laboratorio5.R.layout.add_question_fragment, LAYOUT_ADDQUESTIONFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.laboratorio5.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.laboratorio5.R.layout.question_fragment, LAYOUT_QUESTIONFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.laboratorio5.R.layout.resultados_fragment, LAYOUT_RESULTADOSFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ADDQUESTIONFRAGMENT: {
          if ("layout/add_question_fragment_0".equals(tag)) {
            return new AddQuestionFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for add_question_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_QUESTIONFRAGMENT: {
          if ("layout/question_fragment_0".equals(tag)) {
            return new QuestionFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for question_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_RESULTADOSFRAGMENT: {
          if ("layout/resultados_fragment_0".equals(tag)) {
            return new ResultadosFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for resultados_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "am");
      sKeys.put(2, "amq");
      sKeys.put(3, "user");
      sKeys.put(4, "user19");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/add_question_fragment_0", com.example.laboratorio5.R.layout.add_question_fragment);
      sKeys.put("layout/fragment_home_0", com.example.laboratorio5.R.layout.fragment_home);
      sKeys.put("layout/question_fragment_0", com.example.laboratorio5.R.layout.question_fragment);
      sKeys.put("layout/resultados_fragment_0", com.example.laboratorio5.R.layout.resultados_fragment);
    }
  }
}
