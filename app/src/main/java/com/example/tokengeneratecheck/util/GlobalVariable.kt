package com.example.tokengeneratecheck.util

import androidx.multidex.MultiDexApplication

class GlobalVariable : MultiDexApplication() {

    var password: String? = ""
    var userName: String? = ""
    var sessionTime: String? = ""
    var tokenNo: String? = ""
}