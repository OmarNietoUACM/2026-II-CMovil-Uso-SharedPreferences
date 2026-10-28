package com.example.a2026_ii_uso_sharedpreferences

import android.app.Application

class UsoSharePreferenceAplication: Application() {

    companion object {
        lateinit var preferencias: Preferencias
    }

    override fun onCreate() {
        super.onCreate()
        preferencias = Preferencias(applicationContext)
    }


}