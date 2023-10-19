package com.example.protectstandhogg

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.protectstandhogg.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, Next2Activity::class.java).apply {
            }
            startActivity(intent)
        }

        binding.button1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
            }
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            showNotification("Hello")
        }

    }

    private fun showNotification(message: String) {
        val channelId = "hello"
        val title = "Title"
        val content = "Content"
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(parsePendingIntent(content))
            .setAutoCancel(true)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.app_name)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                setShowBadge(true)
            }
            manager.createNotificationChannel(channel)
        }
        val id = System.currentTimeMillis().div(1000).toInt()
        manager.notify(id, builder.build())
    }

    private fun parsePendingIntent(data: String): PendingIntent? {
        val intent = Intent(this, NotificationActivity::class.java).apply {

        }

        val flags = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                // Solution for App crash on Android 12 and above.
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
            }

            else -> PendingIntent.FLAG_UPDATE_CURRENT
        }

        Log.d("Mark33", "successfuil")
        return PendingIntent.getActivity(this, 0, intent, flags)
    }
}
