package com.example.coins.presentation

import android.app.Application
import androidx.work.Configuration
import com.example.coins.di.DaggerApplicationComponent
import com.example.coins.workers.CoinWorkerFactory
import javax.inject.Inject
import kotlin.getValue

class CoinApp : Application(), Configuration.Provider {

    @Inject
    lateinit var coinWorkerFactory: CoinWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(coinWorkerFactory)
            .build()
}