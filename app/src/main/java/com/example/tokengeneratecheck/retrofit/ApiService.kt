package com.example.tokengeneratecheck.retrofit

import com.example.tokengeneratecheck.datamodel.TokenDataM
import com.example.tokengeneratecheck.requestmodel.TokenRequestM
import com.example.tokengeneratecheck.util.Constrants_Variable
import com.example.tokengeneratecheck.util.GlobalVariable
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ApiService {
    private val baseurl = "http://10.11.201.44:8084/TokenCheck/"

    private lateinit var globalVariable: GlobalVariable


    var okHttpClient: OkHttpClient? = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .header("Authorization", Constrants_Variable.headerUserPass)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        .build()

    var gson = GsonBuilder()
        .setLenient()
        .create()


    private val api = Retrofit.Builder()
        .baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
        .create(Api::class.java);

    fun getToken(model: TokenRequestM): Single<TokenDataM> {
        return api.getToken(
            model.requestCode,
            model.userName,
            model.password
        )
    }

}