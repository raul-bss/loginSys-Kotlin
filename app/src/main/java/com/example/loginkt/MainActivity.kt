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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var username: EditText = findViewById(R.id.campoUsuario)
        var password: EditText = findViewById(R.id.campoSenha)
        var btnLogin: Button = findViewById(R.id.btnLogin)
        var registrar:TextView = findViewById(R.id.signUp)

        var controller: UsuarioController= UsuarioController(this)


        registrar.setOnClickListener(View.OnClickListener {
                var intent: Intent = Intent(this,RegisterActivity::class.java)
                startActivity(intent)
        })

        btnLogin.setOnClickListener(View.OnClickListener {
            var usuario: String = username.text.toString()
            var senha: String = password.text.toString()
            var result:Boolean = false

            if(usuario.isEmpty() || senha.isEmpty()){
                Toast.makeText(this,"campos vazios",Toast.LENGTH_SHORT).show()
            }else{
                try{
                    result = controller.checkLogin(usuario,senha)
                }catch (e: Exception){
                    Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

                }


                if(result == true){
                    var intent: Intent = Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"senha ou usuario inválido",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}