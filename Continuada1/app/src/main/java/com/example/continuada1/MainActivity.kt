package com.example.continuada1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.makeText
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var isValid = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//rentabilidade
            }
    fun onClick(view:View){

        var investmentType = et_investido.text.toString()
        var valueInvestment:String = et_compra.text.toString()
        var valueActual = et_atual.text.toString()

        validateFieldTypeInvestment(investmentType)
        validateFieldValueInvested(valueInvestment)
        validateFieldActualValue(valueActual)
        calculatesRentability(valueInvestment, valueActual)

    }
  fun validateFieldTypeInvestment(typeInvestment:String):String{

      if(typeInvestment.equals("TD") || typeInvestment.equals("TD ") ||
          typeInvestment.equals("RV") || typeInvestment.equals("RV ")) {
          Toast.makeText(this, "Proximo Campo", Toast.LENGTH_SHORT).show()
      }
      else
          Toast.makeText(this, "Tipo Invalido", Toast.LENGTH_SHORT).show()

return typeInvestment
      }

    fun validateFieldValueInvested(valueInvestment:String):String{

        try {
    if(valueInvestment.toDouble() <= 0 || valueInvestment.isNullOrEmpty())
        Toast.makeText(this, "Valor não pode ser menor que 0", Toast.LENGTH_LONG).show()
}
        catch (a:Exception){

        }

        return valueInvestment
    }

    fun validateFieldActualValue(valueActual:String):String{

        try {
            if(valueActual.toDouble() <= 0 || valueActual.isNullOrEmpty())
                Toast.makeText(this, "Valor atual não pode ser menor que 0", Toast.LENGTH_LONG).show()
        }
        catch (a:Exception){

        }

        return valueActual
    }

    fun calculatesRentability(valorCompra:String, valorAtual:String){
        var a =validateFieldActualValue(valorAtual)
        var rentabilidadeNegativa = 0.0
        var rentabilidadePositiva = 0.0

      if(valorCompra > valorAtual) {
          tv_texto_rentabilidade.setTextColor(Color.RED)
          rentabilidadeNegativa = valorCompra.toDouble() - valorAtual.toDouble()
          tv_texto_rentabilidade.text = "Sua rentabilidade é: - R$ ${rentabilidadeNegativa} "
      }
        else if(valorCompra < valorAtual){
          tv_texto_rentabilidade.setTextColor(Color.GREEN)
          rentabilidadePositiva = valorAtual.toDouble() - valorCompra.toDouble()
          tv_texto_rentabilidade.text = "Sua rentabilidade é: + R$ ${rentabilidadePositiva}"
      }
        else{
          tv_texto_rentabilidade.setTextColor(Color.parseColor("#FFCA33"))
          tv_texto_rentabilidade.text = "Não houve mudanças na rentabilidade, Saldo: R$ ${valorAtual}"
      }
    }
 }


