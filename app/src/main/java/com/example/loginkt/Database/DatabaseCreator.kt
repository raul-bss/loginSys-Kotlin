package com.example.loginkt.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseCreator : SQLiteOpenHelper {

    var DATABASE_NAME: String = "raul.db"
    val TABELA: String = "usuarios_tb"
    val ID:String = "_id"
    val NOME:String = "nome"
    val USUARIO:String = "usuario"
    val SENHA:String = "senha"
    val EMAIL:String = "email"


    constructor(context: Context?) : super(context,"raul.db",null,1) {

    }
    override fun onCreate(db: SQLiteDatabase?) {


         var sb: StringBuilder = StringBuilder();

        sb.append("CREATE TABLE ").append(TABELA);
        sb.append("(");
        sb.append(ID).append(" integer primary key autoincrement,");
        sb.append(NOME).append(" text,");
        sb.append(USUARIO).append(" text,");
        sb.append(SENHA).append(" integer,");
        sb.append(EMAIL).append(" text");
        sb.append(")");

        var sqlQuery: String = sb.toString();

        db?.execSQL(sqlQuery);
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABELA)
        onCreate(db)
    }
}