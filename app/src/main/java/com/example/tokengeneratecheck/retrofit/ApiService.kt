package com.example.tokengeneratecheck.retrofit

import com.example.tokengeneratecheck.datamodel.TokenDataM
import com.example.tokengeneratecheck.requestmodel.TokenRequestM
import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    var baseurl = "http://10.11.201.44:8084/JavaToken/"

    var gson = GsonBuilder()
        .setLenient()
        .create()

    var api = Retrofit.Builder()
        .baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build().create(Api::class.java)

    fun getToken(model: TokenRequestM): Single<List<TokenDataM>> {
        return api.getToken(
            model.requestCode,
            model.userName,
            model.password

        )
    }

}