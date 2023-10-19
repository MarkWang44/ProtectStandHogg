package com.example.protectstandhogg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.protectstandhogg.databinding.ActivityNext2Binding

class Next2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityNext2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNext2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java).apply {
            }
            startActivity(intent)
        }

        binding.button1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
}
