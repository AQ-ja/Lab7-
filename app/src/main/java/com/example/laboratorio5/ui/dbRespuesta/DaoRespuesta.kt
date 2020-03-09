package com.example.laboratorio5.ui.dbRespuesta

import androidx.room.*
import androidx.room.Dao
import com.example.laboratorio5.ui.db.DataBase
import com.example.laboratorio5.ui.dbEncuesta.DataBaseEncuesta

@Dao
interface DaoRespuesta {
    @Query("SELECT * FROM DataBaseRespuesta")
    fun getAll(): List<DataBaseRespuesta>

    @Insert
    fun insertAll(vararg users: DataBaseRespuesta)

    @Query("SELECT * FROM DataBaseRespuesta WHERE poll_id LIKE :search ")
    fun findid(search: Int): List<DataBaseRespuesta>

    @Query("SELECT * FROM DataBaseRespuesta WHERE question_id LIKE :search ")
    fun find(search: Int): List<DataBaseRespuesta>

}