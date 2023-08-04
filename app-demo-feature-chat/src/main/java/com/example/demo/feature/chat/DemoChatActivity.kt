package com.example.demo.feature.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.feature.chat.databinding.ActivityDemoChatBinding
import com.example.feature.chats.list.ChatsListFragment

class DemoChatActivity : AppCompatActivity() {

    lateinit var binding: ActivityDemoChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.demo_chat_container, ChatsListFragment())
            .commit()

    }

}