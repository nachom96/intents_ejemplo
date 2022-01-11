package com.example.intentsejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.intentsejemplo.databinding.MainActivityBinding
import com.example.intentsejemplo.utils.hideSoftKeyboard


private const val EXTRA_NAME = "EXTRA_NAME"
private const val EXTRA_AGE = "EXTRA_AGE"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    // 9º
    private fun setupViews() {
        binding.txtAge.setOnEditorActionListener { _, _, _ ->
            btnShowOnClick()
            true
        }
        binding.btnShow.setOnClickListener { btnShowOnClick() }
    }

    // 7º
    private fun btnShowOnClick() {
        val name = binding.txtName.text.toString()
        val age = binding.txtAge.text.toString()
        if (isValidForm(name, age)){
            binding.txtName.hideSoftKeyboard()
            navigateToDetailActivity(name, age.toInt())
        }
    }

    // 5º Si el nombre o la edad son incorrectas, se pone el foco en ellas
    private fun isValidForm(name: String, ageText: String) : Boolean{
        if (!validateName(name)) {
            binding.txtName.requestFocus()
            return false
        }
        if (!validateAge(ageText)) {
            binding.txtAge.requestFocus()
            return false
        }
        return true
    }

    // 4º
    private fun validateName(name: String): Boolean{
        return if (isValidName(name)) {
            binding.txtName.error = null
            true
        } else {
            binding.txtName.error = getString(R.string.main_invalid_name)
            false
        }
    }

    // 3º Se le pasa la edad. Si es válida el mensaje de error desaparece, si no se muestra.
    private fun validateAge(ageText: String): Boolean{
        return if (isValidAge(ageText)){
            binding.txtAge.error = null
            true
        } else{
            binding.txtAge.error = getString(R.string.main_invalid_age)
            false
        }
    }

    // 2º
    private fun isValidName(name: String): Boolean = name.isNotEmpty()

    // 1º
    private fun isValidAge(ageText: String): Boolean{
        // Devuelve un int o un null si no se puede transformar a int. El elvis sirve para retornar false en caso de ser null.
        val age = ageText.toIntOrNull() ?: return false
        // validRange es el valor entre el que puede estar contenido la edad pasada.
        // contains comprueba que el valor introducido está entre el validRange
        val validRange = 1..130
        return validRange.contains(age)
    }

    // 8º
    // Hay que crear la actividad DetailActivity
    // Ver Tema 5 -> Proyecto ExplicitIntent -> Asistente de nueva actividad
    private fun navigateToDetailActivity(name: String, age: Int){
        // 10º
        startActivity(DetailActivity.newIntent(this, name, age))
    }




}