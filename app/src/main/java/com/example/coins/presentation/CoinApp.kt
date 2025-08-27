package com.example.coins.presentation

import android.app.Application
import com.example.coins.di.DaggerApplicationComponent
import kotlin.getValue

class CoinApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}