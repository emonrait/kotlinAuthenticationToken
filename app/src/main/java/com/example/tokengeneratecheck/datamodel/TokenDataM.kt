package com.example.tokengeneratecheck.datamodel

import com.google.gson.annotations.SerializedName

data class TokenDataM(

    @SerializedName("requestCode")
    var requestCode: String?,

    @SerializedName("userName")
    var userName: String?,

    @SerializedName("password")
    var password: String?,

    @SerializedName("tokenNo")
    var tokenNo: String?,

    @SerializedName("outCode")
    var outCode: String?,

    @SerializedName("outMessage")
    var outMessage: String?,

    @SerializedName("sessionTime")
    var sessionTime: String?


)