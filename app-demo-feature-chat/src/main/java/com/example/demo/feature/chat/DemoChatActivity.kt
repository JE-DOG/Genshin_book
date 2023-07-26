package com.example.demo.feature.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.feature.chat.databinding.ActivityDemoChatBinding

class DemoChatActivity : AppCompatActivity() {

    lateinit var binding: ActivityDemoChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
                // todo add chat container
//            .replace(R.id.demo_chat_container,)
            .commit()

    }

}