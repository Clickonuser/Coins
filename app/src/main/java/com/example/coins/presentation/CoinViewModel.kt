package com.example.coins.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.coins.data.repository.CoinRepositoryImpl
import com.example.coins.domain.GetCoinInfoListUseCase
import com.example.coins.domain.GetCoinInfoUseCase
import com.example.coins.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)
    private val loadDataUseCase = LoadDataUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    val coinInfoList = getCoinInfoListUseCase()

    fun detailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }
}