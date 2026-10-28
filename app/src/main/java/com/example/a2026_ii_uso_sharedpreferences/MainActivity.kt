package com.example.a2026_ii_uso_sharedpreferences

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a2026_ii_uso_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var usuarioPref: UsuarioPref



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        leerPreferencias()
        initComponentes()


        //val inputText = outlinedTextField.editText?.text.toString()
    }


    private fun leerPreferencias() {
        usuarioPref = UsoSharePreferenceAplication.preferencias.leerUsuarioPref()
    }

    private fun guardarPreferencias() {
        usuarioPref.id = binding.idUsuario.editText?.text.toString().toInt()
        usuarioPref.user = binding.nombreUsuario.editText?.text.toString()
        usuarioPref.correo = binding.correoUsuario.editText?.text.toString()
        usuarioPref.enableSalvarDatos = binding.cbGuardar.isChecked

        UsoSharePreferenceAplication.preferencias.guadarUsuarioPref(usuarioPref)
    }

    private fun initComponentes() {
        binding.idUsuario.editText?.setText( usuarioPref.id.toString())
        binding.nombreUsuario.editText?.setText( usuarioPref.user)
        binding.correoUsuario.editText?.setText( usuarioPref.correo)
        binding.cbGuardar.isChecked = usuarioPref.enableSalvarDatos

        binding.btnIngresar.setOnClickListener {
            guardarPreferencias()
            Toast.makeText(this, "Se ha apretaqado el boton", Toast.LENGTH_LONG).show()
        }

        binding.cbGuardar.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked){
                guardarPreferencias()
            }
            else { //Unchecked

                binding.idUsuario.editText?.setText( "0")
                binding.nombreUsuario.editText?.setText( "")
                binding.correoUsuario.editText?.setText( "")
                binding.cbGuardar.isChecked = false
                guardarPreferencias()

            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()

    }


}