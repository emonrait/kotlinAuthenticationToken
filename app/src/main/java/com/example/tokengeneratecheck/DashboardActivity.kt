package com.example.tokengeneratecheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tokengeneratecheck.util.Constrants_Variable
import com.example.tokengeneratecheck.util.GlobalVariable
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var globalVariable: GlobalVariable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        globalVariable = this.applicationContext as GlobalVariable

        tvusername.setText(globalVariable.userName)
        tvToken.setText(Constrants_Variable.headerUserPass)
    }
}