package com.example.laboratorio5.ui.dbRespuesta;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J!\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\f\"\u00020\u0004H\'\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/example/laboratorio5/ui/dbRespuesta/DaoRespuesta;", "", "find", "", "Lcom/example/laboratorio5/ui/dbRespuesta/DataBaseRespuesta;", "search", "", "findid", "getAll", "insertAll", "", "users", "", "([Lcom/example/laboratorio5/ui/dbRespuesta/DataBaseRespuesta;)V", "app_debug"})
public abstract interface DaoRespuesta {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM DataBaseRespuesta")
    public abstract java.util.List<com.example.laboratorio5.ui.dbRespuesta.DataBaseRespuesta> getAll();
    
    @androidx.room.Insert()
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    com.example.laboratorio5.ui.dbRespuesta.DataBaseRespuesta... users);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM DataBaseRespuesta WHERE poll_id LIKE :search ")
    public abstract java.util.List<com.example.laboratorio5.ui.dbRespuesta.DataBaseRespuesta> findid(int search);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM DataBaseRespuesta WHERE question_id LIKE :search ")
    public abstract java.util.List<com.example.laboratorio5.ui.dbRespuesta.DataBaseRespuesta> find(int search);
}