package com.example.coins.presentation

import androidx.lifecycle.ViewModel
import com.example.coins.domain.GetCoinInfoListUseCase
import com.example.coins.domain.GetCoinInfoUseCase
import com.example.coins.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun detailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}