package com.example.tokengeneratecheck.retrofit

import com.example.tokengeneratecheck.datamodel.TokenDataM
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("tokencheckapi")
    fun getToken(
        @Field("requestCode") requestCode: String?,
        @Field("userName") userName: String?,
        @Field("password") password: String?

    ): Single<TokenDataM>
}