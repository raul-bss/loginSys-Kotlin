package com.example.loginkt.Usuario.Controller

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.loginkt.Database.DatabaseCreator
import com.example.loginkt.Usuario.Model.Usuario
import com.example.loginkt.Usuario.Service.UsuarioService

class UsuarioController {
    private var service: UsuarioService? = null

    constructor(context: Context?){
        this.service = UsuarioService(context)
    }

    fun inserir(usuario: Usuario): Boolean {
        return service!!.inserir(usuario)
    }

    fun checkLogin(usuario: String, senha: String): Boolean{
        return service!!.checkLogin(usuario,senha)
    }


}