package com.example.app.demo.authorization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_demo_authorization.R
import com.example.core.app.navigation.ScreenProvider
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class DemoAuthorizationActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screenProvider: ScreenProvider

    private val appNavigator = AppNavigator(this,R.id.container_authorization)
    private val appComponent = App.INSTANCE.appComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_authorization)
        appComponent.inject(this)

        router.replaceScreen(
            screenProvider.signIn()
        )
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