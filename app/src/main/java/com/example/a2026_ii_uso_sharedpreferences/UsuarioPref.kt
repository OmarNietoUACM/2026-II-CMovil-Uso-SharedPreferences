package com.example.a2026_ii_uso_sharedpreferences

data class UsuarioPref (
    var id:Int,
    var user: String,
    var correo: String,
    var enableSalvarDatos: Boolean){

    companion object {
        val ID_KEY = "ID_KEY"
        val USER_KEY = "USER_KEY"
        val CORREO_KEY = "CORREO_KEY"
        val SALVAR_DATOS_KEY = "SALVAR_DATOS_KEY"
    }
}