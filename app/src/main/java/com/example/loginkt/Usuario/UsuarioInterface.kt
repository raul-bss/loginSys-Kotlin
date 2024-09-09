package com.example.loginkt.Usuario

import com.example.loginkt.Usuario.Model.Usuario

interface UsuarioInterface {
    fun inserir(usuario: Usuario): Boolean
    fun checkLogin(usuario: String, senha: String):Boolean
}