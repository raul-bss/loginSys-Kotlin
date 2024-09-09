package com.example.loginkt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginkt.Usuario.Controller.UsuarioController
import com.example.loginkt.Usuario.Model.Usuario

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var nome: EditText = findViewById(R.id.campoNomeCompleto)
        var username: EditText = findViewById(R.id.campoUsuario)
        var password: EditText = findViewById(R.id.campoSenha)
        var email: EditText = findViewById(R.id.campoEmail)
        var btnCadastrar: Button = findViewById(R.id.btnCadastrar)
        var login: TextView = findViewById(R.id.logIn)

        login.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

        btnCadastrar.setOnClickListener(View.OnClickListener {

            var controller: UsuarioController = UsuarioController(this)
            var nomeCad: String = nome.text.toString()
            var usuarioCad: String = username.text.toString()
            var senhaCad: String = password.text.toString()
            var emailCad: String = password.text.toString()
            var resultado:Boolean =false

            if(nomeCad.isEmpty() || usuarioCad.isEmpty() || senhaCad.isEmpty() || emailCad.isEmpty()){
                Toast.makeText(this,"campos vazios", Toast.LENGTH_SHORT).show()
            }else {

                var obj: Usuario = Usuario()
                obj.nome = nomeCad
                obj.usuario = usuarioCad
                obj.senha = senhaCad
                obj.email = emailCad

                try {
                    resultado = controller.inserir(obj)
                }catch (e: Exception){
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }

                if (resultado == true) {
                    var intent: Intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "algo deu errado", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}