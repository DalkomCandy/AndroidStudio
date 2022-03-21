package com.seook.travelapp_hanium.Login_Service

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.seook.travelapp_hanium.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_setting.*

class LoginActivity :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener {
            var textid = textid.text.toString()
            var textpw = textpw.text.toString()

            var dialog = AlertDialog.Builder(this)
            dialog.setTitle("alarm")
            dialog.setMessage(("id = " + textid + "pw - " + textpw))
        }
    }
}

