package com.example.laboratorio5.ui.dbRespuesta

import androidx.room.*
import com.example.laboratorio5.ui.db.AppDatabase
import com.example.laboratorio5.ui.db.DataBase
import com.example.laboratorio5.ui.dbEncuesta.DataBaseEncuesta


@Entity()
data class DataBaseRespuesta (
    @PrimaryKey(autoGenerate = true) val id: Int?,

    @ColumnInfo(name = "poll_id")
    val poll_id: Int,

    @ColumnInfo(name = "question_id")
    val question_id: Int,

    @ColumnInfo(name = "answer")
    val answer: String
)