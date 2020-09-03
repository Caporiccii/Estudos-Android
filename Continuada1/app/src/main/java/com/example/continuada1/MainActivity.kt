package com.example.continuada1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //apagar comentarios
        //calcular tempo de quarentena de cada pessoa
        //dias que não sai de casa
        //dias que saiu
        //verde para acima de 100 horas amarelo 50 vermelho 20
    }
    fun aoClicar(view:View){
        tv_texto_resultado.text = "Você ficou ${14} dias de quarentena"
    }
}