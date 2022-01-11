package com.example.intentsejemplo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.intentsejemplo.databinding.DetailActivityBinding

class DetailActivity : AppCompatActivity() {

    /* A la hora de desarrollar una actividad que pueda ser iniciada mediante
       un intent explícito por otra actividad, suele ser más elegante proporcionar
       en la actividad que va a ser llamada un método estático que reciba el contexto y todos los argumentos*/

    // 9º Se crea el companion object que será llamado desde el MainActivity
    companion object {

        const val EXTRA_NAME = "EXTRA_NAME"
        const val EXTRA_AGE = "EXTRA_AGE"

        fun newIntent(context: Context, name: String, age: Int) =
            Intent(context, DetailActivity::class.java)
                .putExtras(bundleOf(EXTRA_NAME to name, EXTRA_AGE to age))

    }

    private lateinit var binding: DetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}