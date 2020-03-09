package com.example.laboratorio5.ui.db
import androidx.room.*

@Entity
data class DataBase (
    @PrimaryKey(autoGenerate = true) val id: Int?,

    @ColumnInfo(name = "tipo")
    val tipo: String,

    @ColumnInfo(name = "pregunta")
    val pregunta: String,

    @ColumnInfo(name = "defaul")
    val defaul: Boolean
)
