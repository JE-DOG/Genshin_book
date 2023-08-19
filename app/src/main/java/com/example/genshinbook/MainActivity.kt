package com.example.genshinbook

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.core.app.ext.currentFragmentInBackStack
import com.example.core.app.navigation.ScreenProvider
import com.example.genshinbook.databinding.ActivityMainBinding
import com.example.feature.authorization.screen.sign_in.SignInFragment
import com.example.feature.authorization.screen.sign_up.SignUpFragment
import com.example.feature.chat.dialog.ChatDialogFragment
import com.example.genshinbook.utils.ext.appComponent
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.github.jan.supabase.realtime.realtime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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


        initNavigation()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(appNavigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun initNavigation(){

        supportFragmentManager.apply {

            addOnBackStackChangedListener {

                setBottomNavigationVisible(currentFragmentInBackStack)

            }

            addFragmentOnAttachListener { fragmentManager, fragment ->

                setBottomNavigationVisible(fragment)

            }

        }


        binding.bottomNav.setOnItemSelectedListener { item ->

            when(item.itemId){

                R.id.bn_nav_home -> {
                    router.newRootScreen(
                        screenProvider.main()
                    )

                    return@setOnItemSelectedListener true
                }

                R.id.bn_nav_chats -> {
                    router.newRootScreen(
                        screenProvider.chatsList()
                    )

                    return@setOnItemSelectedListener true
                }

                R.id.bn_nav_profile -> {
                    router.newRootScreen(
                        screenProvider.profile()
                    )

                    return@setOnItemSelectedListener true
                }

            }

            false
        }

        if (userId.isEmpty()){
            router.newRootScreen(
                screenProvider.signIn()
            )
        }else {
            router.newRootScreen(
                screenProvider.main()
            )
        }

    }

    private fun setBottomNavigationVisible(fragment: Fragment) {

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

}
