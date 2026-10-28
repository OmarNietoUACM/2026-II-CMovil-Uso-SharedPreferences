package com.example.a2026_ii_uso_sharedpreferences

import android.content.Context

class Preferencias(context: Context) {
    val PREF_FILE_NAME = "com.example.a2026_ii_uso_sharedpreferences.user_preferences"
    val prefFile = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)

    fun guadarUsuarioPref(usuarioPref: UsuarioPref){
        prefFile.edit()
            .putInt(UsuarioPref.ID_KEY, usuarioPref.id).apply()
        prefFile.edit()
            .putString(UsuarioPref.USER_KEY, usuarioPref.user).apply()
        prefFile.edit()
            .putString(UsuarioPref.CORREO_KEY, usuarioPref.correo).apply()
        prefFile.edit()
            .putBoolean(UsuarioPref.SALVAR_DATOS_KEY, usuarioPref.enableSalvarDatos).apply()
    }

    fun leerUsuarioPref(): UsuarioPref{
        val id = prefFile.getInt(UsuarioPref.ID_KEY, 0)
        val nombre = prefFile.getString(UsuarioPref.USER_KEY, "") ?: ""
        val correo = prefFile.getString(UsuarioPref.CORREO_KEY, "") ?: ""
        val guardarDatos = prefFile.getBoolean(UsuarioPref.SALVAR_DATOS_KEY, false) ?: false
        return UsuarioPref(id, nombre, correo, guardarDatos)
    }

}