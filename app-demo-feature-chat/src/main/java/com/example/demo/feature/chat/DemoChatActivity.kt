package com.example.demo.feature.chat


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.core.app.navigation.ScreenProvider
import com.example.demo.feature.chat.databinding.ActivityDemoChatBinding
import com.example.feature.chats.list.ChatsListFragment
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class DemoChatActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screenProvider: ScreenProvider

    lateinit var binding: ActivityDemoChatBinding
    private val navigator = AppNavigator(this, R.id.demo_chat_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        App.INSTANCE.appComponent.inject(this)

        router.newRootScreen(
            screenProvider.chatsList()
        )


    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}