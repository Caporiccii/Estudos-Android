package com.example.idolos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.continuada2.model.Idolos
import com.example.idolos.repository.IdolosRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val novaTextView = TextView(baseContext)

        val ll_conteudo = findViewById<LinearLayout>(R.id.ll_conteudo)

    }

    fun goToGalleryActivity(){
        val gallery = Intent(this, GalleryActivity::class.java)

        startActivity(gallery)
    }

    fun redirectIdol(View:View){
        goToGalleryActivity()
        }

    fun getIdols(View: View){

        val getIdolsIntance: Call<List<Idolos>> = RetrofitImplementation().criarRequisiçoes().getIdolos()
        val novaTextView = TextView(baseContext)

        val ll_conteudo = findViewById<LinearLayout>(R.id.ll_conteudo)
        getIdolsIntance.enqueue(object : Callback<List<Idolos>>{
            override fun onResponse(call: Call<List<Idolos>>, response: Response<List<Idolos>>) {
                val idolos = response.body()?.forEach{
                    novaTextView.text = "Id: ${it.id}, Nome: ${it.Nome}, Posição: ${it.Posicao}, Primeira Copa: " +
                            "${it.AnoPrimeiraCopa}, Quantas Copas: ${it.QtdCopas}"

                    ll_conteudo.addView(novaTextView)
                }
            }

            override fun onFailure(call: Call<List<Idolos>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro: $t", Toast.LENGTH_SHORT).show()
                println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOOO $t")
                Logger.getLogger("Erro $t")

            }

        })
    }
}