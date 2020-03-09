package com.example.laboratorio5.ui.dbEncuesta

import androidx.room.*
import java.sql.Date

@Entity
data class DataBaseEncuesta (
    @PrimaryKey(autoGenerate = true) val id: Int?,

    @ColumnInfo(name = "fecha_creacion")
    val fecha_creacion: String
)
