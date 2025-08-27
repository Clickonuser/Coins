package com.example.coins.di

import android.app.Application
import com.example.coins.data.database.AppDatabase
import com.example.coins.data.database.CoinInfoDao
import com.example.coins.data.repository.CoinRepositoryImpl
import com.example.coins.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {
        @Provides
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }
    }
}