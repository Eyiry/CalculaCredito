package mx.lcv.calculacredito

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private val CODIGO_CALCULA_CREDITO = 600

    fun calcularCredito(v:View){
        //Lanza segunda Pantalla

        //Pasar tipo tarjeta

        val intCalcularCredito = Intent(this, CalcularCredito::class.java)
        val tipoTarjeta = spinnerTipoTarjeta.selectedItemPosition

        intCalcularCredito.putExtra("tipoTarjeta", tipoTarjeta)
        //Regresa un valor

        startActivityForResult(intCalcularCredito, CODIGO_CALCULA_CREDITO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == CODIGO_CALCULA_CREDITO){
            if (resultCode == Activity.RESULT_OK){
                if (data != null){
                    val limiteCredito = data.getIntExtra("limiteCredito", -1)
                    etLimiteCredito.setText("$limiteCredito")
                }
            }
        }
    }
}
