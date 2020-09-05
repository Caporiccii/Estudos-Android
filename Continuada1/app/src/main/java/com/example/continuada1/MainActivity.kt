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

        var firstFieldValidation = validateFieldTypeInvestment(investmentType)
        var secondFieldValidation = validateFieldValueInvested(valueInvestment)
        var thirdFieldValidation = validateFieldActualValue(valueActual)

        if(firstFieldValidation == true && secondFieldValidation == true && thirdFieldValidation==true )
        calculatesRentability(valueInvestment, valueActual)

    }
  fun validateFieldTypeInvestment(typeInvestment:String):Boolean{

      if(typeInvestment.equals("TD") || typeInvestment.equals("TD ") ||
          typeInvestment.equals("RV") || typeInvestment.equals("RV ")) {
        //  Toast.makeText(this, "Proximo Campo", Toast.LENGTH_SHORT).show()
          return true
      }
      else
          Toast.makeText(this, "Tipo Invalido", Toast.LENGTH_SHORT).show()
return false

      }

    fun validateFieldValueInvested(valueInvestment:String):Boolean{

    if(valueInvestment.isNullOrEmpty()) {
        Toast.makeText(this, "Valor investido não pode ser menor que 0", Toast.LENGTH_LONG).show()
        return false
    }
    else
        return true
    }

    fun validateFieldActualValue(valueActual:String):Boolean {

        if(valueActual.isNullOrEmpty()) {
            Toast.makeText(this, "Valor atual não pode ser menor que 0", Toast.LENGTH_LONG).show()
            return false
        }
        else
            return true
    }
    fun calculatesRentability(valorCompra:String, valorAtual:String){

        var rentabilidadeNegativa = 0.0
        var rentabilidadePositiva = 0.0


try {
    if (valorCompra > valorAtual) {
        tv_texto_rentabilidade.setTextColor(Color.RED)
        rentabilidadeNegativa = valorCompra.toDouble() - valorAtual.toDouble()
        tv_texto_rentabilidade.text = "Sua rentabilidade é: - R$ ${rentabilidadeNegativa} "
    } else if (valorCompra < valorAtual) {
        tv_texto_rentabilidade.setTextColor(Color.GREEN)
        rentabilidadePositiva = valorAtual.toDouble() - valorCompra.toDouble()
        tv_texto_rentabilidade.text = "Sua rentabilidade é: + R$ ${rentabilidadePositiva}"
    } else {
        tv_texto_rentabilidade.setTextColor(Color.parseColor("#FFCA33"))
        tv_texto_rentabilidade.text = "Não houve mudanças na rentabilidade, Saldo: R$ ${valorAtual}"
    }
}
catch (ex:Exception){

}
    }
 }



