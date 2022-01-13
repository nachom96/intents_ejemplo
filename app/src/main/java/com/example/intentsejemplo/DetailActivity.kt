package com.example.intentsejemplo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.intentsejemplo.databinding.DetailActivityBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailActivityBinding
    private var name: String = ""
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()
    }

    // 10º Se reciben los datos

    private fun getIntentData() {
        if (intent == null || !intent.hasExtra(EXTRA_NAME) || !intent.hasExtra(EXTRA_AGE)) {
            throw RuntimeException(
                "DetailActivity needs to receive name and age as extras")
        }
        name = intent.getStringExtra(EXTRA_NAME).toString()
        age = intent.getIntExtra(EXTRA_AGE, 0)

        //11º Se muestran los datos
        Toast.makeText(applicationContext, ("Usuario: $name, Edad: $age"), Toast.LENGTH_SHORT).show()

    }


    // 9º Se crea el companion object que será llamado desde el MainActivity
    companion object {

        const val EXTRA_NAME = "EXTRA_NAME"
        const val EXTRA_AGE = "EXTRA_AGE"

        fun newIntent(context: Context, name: String, age: Int) =
            Intent(context, DetailActivity::class.java)
                .putExtras(bundleOf(EXTRA_NAME to name, EXTRA_AGE to age))

    }




}