package com.example.protectstandhogg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.protectstandhogg.databinding.ActivityMainBinding

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        finishAffinity()
//        finishAndRemoveTask()
        val intent = Intent(this, MainActivity::class.java).apply {
        }
        startActivity(intent)
    }
}
