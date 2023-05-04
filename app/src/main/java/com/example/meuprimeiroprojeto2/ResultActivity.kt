package com.example.meuprimeiroprojeto2

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textView_classificacao)

        val result = intent.getFloatExtra( "EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()



        /* TABELA IMC
        MENOR QUE 18,5          MAGREZA
        ENTRE 18,5 E 24,9       NORMAL
        ENTRE 25,0 E 29,9       SOBREPESO I
        ENTRE 30,0 E 39,9       OBESIDADE II
        MAIOR QUE 40,0          OBESIDADE GRAVE III
        */



        val classificacao = if (result < 18.5f){
            "UNDER WEIGHT"
        }else if (result in 18.5f..24.9f){
            "NORMAL"
        }else if (result in 25.0f..29.9f){
            "OVERWEIGHT"
        }else if (result in 30.0f..39.9f){
            "OBESITY II"
        }else{
            "SERIOUS OBESITY"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)

    }

}