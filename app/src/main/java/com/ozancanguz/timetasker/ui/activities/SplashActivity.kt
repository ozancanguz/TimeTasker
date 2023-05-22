package com.ozancanguz.timetasker.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozancanguz.timetasker.R
import com.ozancanguz.timetasker.ui.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        supportActionBar?.hide()
//splash ekran için bir Thread oluşturuyoruz
        val background = object : Thread() {
            override fun run() {
                try {

                    Thread.sleep(6000)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}