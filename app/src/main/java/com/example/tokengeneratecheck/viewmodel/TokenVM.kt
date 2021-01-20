package com.example.tokengeneratecheck.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tokengeneratecheck.datamodel.TokenDataM
import com.example.tokengeneratecheck.requestmodel.TokenRequestM
import com.example.tokengeneratecheck.retrofit.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class TokenVM : ViewModel() {

    private val apiService = ApiService()
    private val disposable = CompositeDisposable()
    var list_token = MutableLiveData<TokenDataM>()


    fun getToken(model: TokenRequestM) {
        disposable.add(
            apiService.getToken(model)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<TokenDataM>() {
                    override fun onSuccess(model: TokenDataM) {
                        list_token.value = model
                        Log.e("RequestCode--->", model.tokenNo.toString())
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        Log.e("Error---", e.message.toString())

                    }

                })
        )
    }


}