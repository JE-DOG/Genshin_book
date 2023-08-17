package com.example.feature.authorization.screen.sign_in

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.core.app.base.BaseFragment
import com.example.core.app.delegate.viewBinding
import com.example.core.app.elements.xml.BaseAlertDialog
import com.example.core.app.ext.stringText
import com.example.core.app.navigation.ScreenProvider
import com.example.feature.authorization.R
import com.example.feature.authorization.databinding.FragmentSignInBinding
import com.example.feature.authorization.di.vm.FeatureAuthorizationComponentViewModel
import com.example.feature.authorization.screen.sign_in.vm.SignInViewModel
import com.example.feature.authorization.screen.sign_up.SignUpFragment
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SignInFragment: BaseFragment(R.layout.fragment_sign_in) {

    @Inject
    lateinit var viewModelFactory: SignInViewModel.Factory
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screenProvider: ScreenProvider

    private val viewModel: SignInViewModel by viewModels {
        viewModelFactory
    }
    private val binding by viewBinding(FragmentSignInBinding::bind)

    private val minPasswordLength by lazy {
        resources
            .getInteger(com.example.core.app.R.integer.min_password_length)
    }

    override fun initDependencies() {

        ViewModelProvider(this)[FeatureAuthorizationComponentViewModel::class.java]
            .component
            .inject(this)

    }

    override suspend fun observeState() {

        viewModel.state.observe(this@SignInFragment){ state ->

            if (state.isError){
                showError(
                    state.isProfileDataIncorrect
                )
            }

            showLoading(state.isLoading)

            if (state.isSignIn){
                router.newRootScreen(
                    screenProvider.main()
                )
            }

        }

    }

    override fun initUi(): Unit = with(binding) {

        signUpButton.apply {

            setOnClickListener {

                Log.d("InitUiFragmentTag","Push to navigate signUp")

                router.navigateTo(
                    screenProvider.signUp()
                )

            }

        }

        signInButton.apply {

            setOnClickListener {

                val email = textInputEmail.stringText
                val password = textInputPassword.stringText

                viewModel.signIn(
                    email = email,
                    password = password
                )

            }

        }


        textInputEmail.addTextChangedListener { enabledButton() }

        textInputPassword.addTextChangedListener { enabledButton() }

        Log.d("InitUiFragmentTag",binding.toString())
    }

    private fun enabledButton() = with(binding) {

        val passwordText = textInputPassword.stringText
        val emailText = textInputEmail.stringText

        val passwordIsCorrect = passwordText.length >= minPasswordLength
        val emailIsCorrect = Patterns.EMAIL_ADDRESS.matcher(emailText).matches()

        if (!emailIsCorrect){
            val emailErrorText = this@SignInFragment
                .resources
                .getString(com.example.core.app.R.string.presentation_text_error_email_input)

            textInputEmail.error = emailErrorText
        }else if (!passwordIsCorrect){
            textInputEmail.error = null

            val passwordErrorText = this@SignInFragment
                .resources
                .getString(com.example.core.app.R.string.presentation_text_error_password_input)

            textInputPassword.error = passwordErrorText
        }else{
            signInButton.isEnabled = true
        }


    }

    private fun showLoading(isShow: Boolean) = with(binding) {

        if (isShow){
            signInButton.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }else {
            progressBar.visibility = View.GONE
            signInButton.visibility = View.VISIBLE
        }

    }

    private fun showError(
        isProfileDataIncorrect: Boolean
    ){

        BaseAlertDialog(
            hasOneAction = true,
            message = if (isProfileDataIncorrect)
                    resources
                        .getString(com.example.core.app.R.string.alert_dialog_error_message_incorrect_data_profile)
                else
                    null
        )
            .show(parentFragmentManager,"")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("InitUiFragmentTag","DestroyView")

    }

}