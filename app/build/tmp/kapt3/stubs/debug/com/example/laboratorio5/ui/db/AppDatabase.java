package com.example.laboratorio5.ui.db;

import java.lang.System;

@androidx.room.Database(entities = {com.example.laboratorio5.ui.db.DataBase.class, com.example.laboratorio5.ui.dbEncuesta.DataBaseEncuesta.class, com.example.laboratorio5.ui.dbRespuesta.DataBaseRespuesta.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/laboratorio5/ui/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "encuesta", "Lcom/example/laboratorio5/ui/dbEncuesta/DaoEncuesta;", "respuesta", "Lcom/example/laboratorio5/ui/dbRespuesta/DaoRespuesta;", "userDao", "Lcom/example/laboratorio5/ui/db/Dao;", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.laboratorio5.ui.db.Dao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.laboratorio5.ui.dbEncuesta.DaoEncuesta encuesta();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.laboratorio5.ui.dbRespuesta.DaoRespuesta respuesta();
    
    public AppDatabase() {
        super();
    }
}