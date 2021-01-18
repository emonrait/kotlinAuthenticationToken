package com.example.tokengeneratecheck.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tokengeneratecheck.datamodel.TokenDataM
import com.example.tokengeneratecheck.retrofit.ApiService
import io.reactivex.disposables.CompositeDisposable

class TokenVM : ViewModel() {

    private val apiService = ApiService()
    private val disposable = CompositeDisposable()
    var list_token = MutableLiveData<List<TokenDataM>>();
}