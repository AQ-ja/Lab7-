package com.example.laboratorio5.ui.db
import android.content.Context
import androidx.room.*
import com.example.laboratorio5.ui.dbEncuesta.DaoEncuesta
import com.example.laboratorio5.ui.dbEncuesta.DataBaseEncuesta
import com.example.laboratorio5.ui.dbRespuesta.DaoRespuesta
import com.example.laboratorio5.ui.dbRespuesta.DataBaseRespuesta

@Database(entities = [DataBase::class, DataBaseEncuesta::class, DataBaseRespuesta::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): Dao
    abstract fun encuesta(): DaoEncuesta
    abstract fun respuesta(): DaoRespuesta
}