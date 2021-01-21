package com.example.tokengeneratecheck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tokengeneratecheck.requestmodel.TokenRequestM
import com.example.tokengeneratecheck.util.Constrants_Variable
import com.example.tokengeneratecheck.util.GlobalVariable
import com.example.tokengeneratecheck.viewmodel.TokenVM
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var tokenVM: TokenVM
    private lateinit var globalVariable: GlobalVariable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_user.setText("admin")
        et_pass.setText("admin")

        globalVariable = this.applicationContext as GlobalVariable



        tokenVM = ViewModelProvider(this).get(TokenVM::class.java)

        btn_signin.setOnClickListener {

            if (!username() or !password()

            ) {
                return@setOnClickListener

            } else {
                //Toast.makeText(applicationContext, "Network", Toast.LENGTH_SHORT).show()
                getToken()
            }
        }

        observeViewModel()


    }

    fun observeViewModel() {

        tokenVM.list_token.observe(this, androidx.lifecycle.Observer {

            it?.let {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                globalVariable.tokenNo = it.tokenNo.toString()
                globalVariable.sessionTime = it.sessionTime.toString()
                globalVariable.userName = it.userName.toString()
                Constrants_Variable.headerUserPass = it.tokenNo.toString()

                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)

            }
        })


    }

    private fun username(): Boolean {

        return if (et_user.text.toString().isEmpty()) {

            et_userLyt.error = "Field can not be empty"
            false
        } else if (et_user.text?.trim()?.isEmpty()!!) {
            et_userLyt.error = "Field Can't be empty"
            false
        } else {
            et_userLyt.error = null
            true
        }
    }

    private fun password(): Boolean {

        return if (et_pass.text.toString().isEmpty()) {

            et_passLyt.error = "Field can not be empty"
            false
        } else if (et_pass.text?.trim()?.isEmpty()!!) {
            et_passLyt.error = "Field Can't be empty"
            false
        } else {
            et_passLyt.error = null
            true
        }
    }

    private fun getToken() {
        var model = TokenRequestM()
        model.requestCode = "1"
        model.userName = et_user.text.toString().trim()
        model.password = et_pass.text.toString().trim()
        this?.let { it1 -> tokenVM.getToken(model) }
    }

}