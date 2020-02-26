package mx.lcv.calculacredito

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calcular_credito.*

class CalcularCredito : AppCompatActivity() {

    private var tipoTarjeta  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_credito)

        tipoTarjeta = intent.getIntExtra("tipoTarjeta", 0)

    }

    fun regresar(v:View){
        var limiteCredito = 0
        val sueldo = etSueldo.text.toString().toInt()
        limiteCredito = when (tipoTarjeta){
            1 -> (sueldo * 2.5).toInt()
            2 -> (sueldo * 5.2).toInt()
            else -> 0
        }

        val intRegreso = Intent()
        intRegreso.putExtra("limiteCredito", limiteCredito)
        setResult(Activity.RESULT_OK, intRegreso)
        finish()
    }
}
