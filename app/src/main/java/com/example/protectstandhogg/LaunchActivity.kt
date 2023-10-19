package com.example.protectstandhogg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.protectstandhogg.databinding.ActivityLaunchBinding

/**
 * 如果有打開 Attack app，則會跟之前狀態一樣，就都會重新打開APP
 * 但如果都沒打開過Attack，就跟原本 app狀態一樣
 */
class LaunchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
            }
//            finishAffinity()
            finishAndRemoveTask()
            startActivity(intent)
            finishAffinity()
        }
    }
}
