package com.example.laboratorio5.ui.verResultados;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\"2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/example/laboratorio5/ui/verResultados/MostrarResultados;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "SharedView", "Lcom/example/laboratorio5/SharedView;", "getSharedView", "()Lcom/example/laboratorio5/SharedView;", "SharedView$delegate", "Lkotlin/Lazy;", "objeto", "Ljava/util/ArrayList;", "Lcom/example/laboratorio5/ui/RecyclerView/Objeto;", "Lkotlin/collections/ArrayList;", "rating", "", "getRating", "()D", "setRating", "(D)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "viewManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "viewModel", "Lcom/example/laboratorio5/ui/verResultados/MostrarResultadosViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onClick", "v", "Landroid/view/View;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "app_debug"})
public final class MostrarResultados extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private double rating;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager viewManager;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private androidx.recyclerview.widget.RecyclerView.Adapter<?> viewAdapter;
    private java.util.ArrayList<com.example.laboratorio5.ui.RecyclerView.Objeto> objeto;
    private final kotlin.Lazy SharedView$delegate = null;
    private com.example.laboratorio5.ui.verResultados.MostrarResultadosViewModel viewModel;
    private java.util.HashMap _$_findViewCache;
    
    public final double getRating() {
        return 0.0;
    }
    
    public final void setRating(double p0) {
    }
    
    private final com.example.laboratorio5.SharedView getSharedView() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    public MostrarResultados() {
        super();
    }
}