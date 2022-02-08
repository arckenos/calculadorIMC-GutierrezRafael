package gutierrez.rafael.asignacion04_calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtResultado: TextView = findViewById(R.id.tvResultado)
        var txtEstado: TextView = findViewById(R.id.tvEstado)
        var etAlutra: EditText = findViewById(R.id.etAltura)
        var etPeso: EditText = findViewById(R.id.etPeso)
        val btnCalcula: Button = findViewById(R.id.btnCalcular)

        btnCalcula.setOnClickListener {
            val imcNUm = this.calcularIMC(
                etAlutra.text.toString().toDouble(),
                etPeso.text.toString().toDouble()
            );
            txtResultado.setText(imcNUm.toString())
            val estado = this.obtenEstado(imcNUm)
            txtEstado.setText(estado)
            when(estado){
                "Bajo peso" -> txtEstado.setBackgroundResource(R.color.colorBrown)
                "Saludable" -> txtEstado.setBackgroundResource(R.color.colorGreen)
                "Sobrepeso" -> txtEstado.setBackgroundResource(R.color.colorGreenish)
                "Obesidad grado 1" -> txtEstado.setBackgroundResource(R.color.colorYellow)
                "Obesidad grado 2" -> txtEstado.setBackgroundResource(R.color.colorOrange)
                "Obesidad grado 3" -> txtEstado.setBackgroundResource(R.color.colorRed)
            }
        }

    }
    fun calcularIMC(altura: Double, peso: Double): Double{
        val imc: Double = (peso / Math.pow(altura, 2.0))
        return imc
    }

    fun obtenEstado(imc: Double): String{
        when{
            imc < 18.5 -> return "Bajo peso"
            imc <= 24.9 -> return "Saludable"
            imc <= 29.9 -> return "Sobrepeso"
            imc <= 34.9 -> return "Obesidad grado 1"
            imc <= 39.9 -> return "Obesidad grado 2"
            imc >= 40 -> return "Obesidad grado 3"
        }


        return "error"
    }
}