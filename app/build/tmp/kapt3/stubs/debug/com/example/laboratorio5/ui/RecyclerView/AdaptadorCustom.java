package com.example.laboratorio5.ui.RecyclerView;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/example/laboratorio5/ui/RecyclerView/AdaptadorCustom;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/laboratorio5/ui/RecyclerView/AdaptadorCustom$ViewHolder;", "items", "Ljava/util/ArrayList;", "Lcom/example/laboratorio5/ui/RecyclerView/Objeto;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getItems", "()Ljava/util/ArrayList;", "setItems", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class AdaptadorCustom extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.laboratorio5.ui.RecyclerView.AdaptadorCustom.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.laboratorio5.ui.RecyclerView.Objeto> items;
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.laboratorio5.ui.RecyclerView.AdaptadorCustom.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.laboratorio5.ui.RecyclerView.AdaptadorCustom.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.laboratorio5.ui.RecyclerView.Objeto> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.laboratorio5.ui.RecyclerView.Objeto> p0) {
    }
    
    public AdaptadorCustom(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.laboratorio5.ui.RecyclerView.Objeto> items) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/example/laboratorio5/ui/RecyclerView/AdaptadorCustom$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vista", "Landroid/view/View;", "(Landroid/view/View;)V", "binditem", "", "data", "Lcom/example/laboratorio5/ui/RecyclerView/Objeto;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public final void binditem(@org.jetbrains.annotations.NotNull()
        com.example.laboratorio5.ui.RecyclerView.Objeto data) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View vista) {
            super(null);
        }
    }
}