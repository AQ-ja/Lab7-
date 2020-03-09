package com.example.laboratorio5.ui.db
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
    @Query("SELECT * FROM `DataBase` ")
    fun getAll(): List<DataBase>

    @Insert
    fun insertAll(vararg users: DataBase)

    @Query("DELETE FROM `DataBase` WHERE `DataBase`.`defaul` = :dayId")
    fun removeAll( dayId : Boolean)

    @Query("SELECT * FROM `DataBase` WHERE id LIKE :search ")
    fun findID(search: Int): List<DataBase>

}