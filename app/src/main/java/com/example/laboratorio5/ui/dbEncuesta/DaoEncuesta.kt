package com.example.laboratorio5.ui.dbEncuesta

import androidx.room.*
import androidx.room.Dao
import com.example.laboratorio5.ui.db.DataBase

@Dao
interface DaoEncuesta {
    @Query("SELECT * FROM DataBaseEncuesta")
    fun getAll(): List<DataBaseEncuesta>

    @Insert
    fun insertAll(vararg users: DataBaseEncuesta)

}