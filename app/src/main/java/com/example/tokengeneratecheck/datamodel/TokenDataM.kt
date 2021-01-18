package com.example.tokengeneratecheck.datamodel

import com.google.gson.annotations.SerializedName

data class TokenDataM (

    @SerializedName("requestCode")
    var requestCode: String?,

    @SerializedName("userName")
    var userName: String?,

    @SerializedName("password")
    var password: String?



){
    override fun toString(): String {
        super.toString()
        return password.toString()
    }


}