package com.example.laboratorio5.ui.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J!\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000b\"\u00020\u0004H\'\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/example/laboratorio5/ui/db/Dao;", "", "findID", "", "Lcom/example/laboratorio5/ui/db/DataBase;", "search", "", "getAll", "insertAll", "", "users", "", "([Lcom/example/laboratorio5/ui/db/DataBase;)V", "removeAll", "dayId", "", "app_debug"})
public abstract interface Dao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM `DataBase` ")
    public abstract java.util.List<com.example.laboratorio5.ui.db.DataBase> getAll();
    
    @androidx.room.Insert()
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    com.example.laboratorio5.ui.db.DataBase... users);
    
    @androidx.room.Query(value = "DELETE FROM `DataBase` WHERE `DataBase`.`defaul` = :dayId")
    public abstract void removeAll(boolean dayId);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM `DataBase` WHERE id LIKE :search ")
    public abstract java.util.List<com.example.laboratorio5.ui.db.DataBase> findID(int search);
}