package com.example.genshinbook

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.example.core.app.navigation.ScreenProvider
import com.example.genshinbook.databinding.ActivityMainBinding
import com.example.feature.main.MainScreen
import com.example.core.app.ui.theme.GenshinBookTheme
import com.example.feature.authorization.screen.sign_in.SignInFragment
import com.example.feature.authorization.screen.sign_up.SignUpFragment
import com.example.feature.chat.dialog.ChatDialogFragment
import com.example.genshinbook.utils.ext.appComponent
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screenProvider: ScreenProvider
    @Inject
    lateinit var userId: String

    private lateinit var binding: ActivityMainBinding

    private val appNavigator = AppNavigator(this,R.id.app_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appComponent.inject(this)

        if (userId.isEmpty()){
            router.newRootScreen(
                screenProvider.signIn()
            )
        }else {
            router.newRootScreen(
                screenProvider.main()
            )
        }

        supportFragmentManager.addFragmentOnAttachListener { fragmentManager, fragment ->

            when(fragment){

                is SignUpFragment -> {
                    binding.bottomNav.visibility = View.GONE
                }

                is SignInFragment -> {
                    binding.bottomNav.visibility = View.GONE
                }

                is ChatDialogFragment -> {
                    binding.bottomNav.visibility = View.GONE
                }

                else -> {
                    binding.bottomNav.visibility = View.VISIBLE
                }

            }

        }
        binding.bottomNav.setOnItemSelectedListener { item ->

            when(item.itemId){

                R.id.bn_nav_home -> {
                    router.navigateTo(
                        screenProvider.main()
                    )
                }

                R.id.bn_nav_chats -> {
                    router.navigateTo(
                        screenProvider.chatsList()
                    )
                }

                R.id.bn_nav_profile -> {
                    router.navigateTo(
                        screenProvider.profile()
                    )
                }

            }

            true
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(appNavigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
