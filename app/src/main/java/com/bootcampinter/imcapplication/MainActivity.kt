package com.bootcampinter.imcapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.bootcampinter.imcapplication.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }
    private fun setListeners() {
        binding.alturaEDT.doAfterTextChanged { text ->
            Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }

        binding.pesoEDT.doOnTextChanged { text, _, _, _ ->
            binding.titleTV.text = text
        }
        binding.buttonCalc.setOnClickListener {
            calcularIMC(binding.pesoEDT.text.toString(), binding.alturaEDT.text.toString())
        }
    }
    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
            if (peso != null && altura != null){
                val imc: Float = peso/(altura * altura)
                binding.titleTV.text = "Seu IMC é %.2f".format(imc)
            }
    }
}
