package com.example.loginkt.Usuario.Service

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.loginkt.Database.DatabaseCreator
import com.example.loginkt.Usuario.Model.Usuario
import com.example.loginkt.Usuario.UsuarioInterface

class UsuarioService: UsuarioInterface {

    private var database: SQLiteDatabase? = null
    private var creator: DatabaseCreator? = null

    constructor(context: Context?){
        this.creator = DatabaseCreator(context)
    }

    override fun inserir(usuario: Usuario): Boolean {

        //Cria um objeto ContentValues que armazena pares chave-valor.
        //As chaves são os nomes das colunas e os valores (EX: COLUNA Nome VALOR nome).
        var valores: ContentValues =  ContentValues();
        var resultado: Long

        database = creator?.getWritableDatabase();

        valores.put(creator!!.NOME,usuario.nome)
        valores.put(creator!!.USUARIO,usuario.usuario)
        valores.put(creator!!.SENHA,usuario.senha)
        valores.put(creator!!.EMAIL,usuario.email)

        resultado = database!!.insert(creator!!.TABELA,null,valores)

        database?.close()

        if (resultado.toInt() == -1){
            return false
        }else{
            return true
        }
    }

    override fun checkLogin(usuario: String, senha: String): Boolean {
        //abre banco de dados em modo escrita
        val db = creator!!.writableDatabase

        //define qual coluna você quer selecionar na consulta
        val columns = arrayOf(creator!!.USUARIO,creator!!.SENHA)

        //definição para seleção dos dados
        //em baixo são os valores para os placeholders (?)
        val selection = "usuario=? AND senha = ?"
        val selectionArgs = arrayOf(usuario, senha)

        //executa a consulta
        val cursor: Cursor = db.query(creator!!.TABELA, columns, selection, selectionArgs, null,null,null)

        var resultado: Boolean
        if (cursor != null && cursor.moveToFirst()) {

            resultado = true
            cursor.close()
        }else{
            resultado = false
        }
        return resultado
    }
}