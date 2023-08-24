package com.example.feature.authorization.screen.sign_up

import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.core.app.ui.xml.base.BaseFragment
import com.example.core.app.delegate.viewBinding
import com.example.core.app.ui.xml.base.BaseAlertDialog
import com.example.core.app.ext.stringText
import com.example.core.app.navigation.ScreenProvider
import com.example.feature.authorization.R
import com.example.feature.authorization.databinding.FragmentSignUpBinding
import com.example.feature.authorization.di.vm.FeatureAuthorizationComponentViewModel
import com.example.feature.authorization.screen.sign_up.vm.SignUpViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SignUpFragment: BaseFragment(R.layout.fragment_sign_up) {

    @Inject
    lateinit var viewModelFactory: SignUpViewModel.Factory
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screenProvider: ScreenProvider

    private val viewModel: SignUpViewModel by viewModels {
        viewModelFactory
    }
    private val binding by viewBinding(FragmentSignUpBinding::bind)

    private val minPasswordLength by lazy {
        resources
            .getInteger(com.example.core.app.R.integer.min_password_length)
    }
    private val minFullNameLength by lazy {
        resources
            .getInteger(com.example.core.app.R.integer.min_full_name_length)
    }
    private val maxFullNameLength by lazy {
        resources
            .getInteger(com.example.core.app.R.integer.max_full_name_length)
    }

    override fun initDependencies() {

        ViewModelProvider(this)[FeatureAuthorizationComponentViewModel::class.java]
            .component
            .inject(this)

    }

    override suspend fun observeState() {

        viewModel.state.observe(this){

            if (it.isSignUp){
                val title = resources
                    .getString(com.example.core.app.R.string.alert_dialog_title_success_sign_up)
                val message = resources
                    .getString(com.example.core.app.R.string.alert_dialog_message_success_sign_up)

                BaseAlertDialog(
                    title = title,
                    message = message,
                    hasOneAction = true,
                    onPositiveButtonClickListener = {
                        router.exit()
                    }
                )
                    .show(parentFragmentManager,"")
            }

            if (it.isError){
                showError()
            }

            showLoading(
                it.isLoading
            )

        }

    }

    override fun initUi(): Unit = with(binding) {

        Log.d("InitUiFragmentTag","InitUi")

        signUpButton.apply {

            setOnClickListener {

                val emailText = textInputEmail.stringText
                val fullNameText = textInputFullName.stringText
                val avatarUrlText = textInputAvatarUrl.stringText
                val passwordText = textInputPassword.stringText

                viewModel.signUp(
                    email = emailText,
                    fullName = fullNameText,
                    avatarUrl = avatarUrlText,
                    password = passwordText
                )

            }

        }

        textInputEmail.addTextChangedListener { enabledButton() }
        textInputFullName.addTextChangedListener { enabledButton() }
        textInputAvatarUrl.addTextChangedListener { enabledButton() }
        textInputPassword.addTextChangedListener { enabledButton() }
        textInputPasswordConfirm.addTextChangedListener { enabledButton() }

    }

    private fun enabledButton() = with(binding) {

        val emailText = textInputEmail.stringText
        val fullNameText = textInputFullName.stringText
        val avatarUrlText = textInputAvatarUrl.stringText
        val passwordText = textInputPassword.stringText
        val confirmPasswordText = textInputPasswordConfirm.stringText

        val emailIsCorrect = Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
        val fullNameIsCorrect = fullNameText.length in minFullNameLength ..  maxFullNameLength
        val avatarUrlIsCorrect = avatarUrlText.isEmpty() || Patterns.WEB_URL.matcher(avatarUrlText).matches()
        val passwordIsCorrect = passwordText.length >= minPasswordLength
        val confirmPasswordIsCorrect = passwordText == confirmPasswordText

        if (!emailIsCorrect){
            val emailErrorText = resources
                .getString(com.example.core.app.R.string.presentation_text_error_email_input)

            textInputEmail.error = emailErrorText
        }else if (!fullNameIsCorrect){
            textInputEmail.error = null

            val fullNameErrorText = resources
                .getString(com.example.core.app.R.string.presentation_text_error_full_name_input)

            textInputFullName.error = fullNameErrorText
        }else if (!avatarUrlIsCorrect) {
            textInputFullName.error = null

            val avatarErrorText = resources
                .getString(com.example.core.app.R.string.presentation_text_error_url_input)

            textInputAvatarUrl.error = avatarErrorText
        } else if (!passwordIsCorrect){
            textInputAvatarUrl.error = null

            val passwordErrorText = resources
                .getString(com.example.core.app.R.string.presentation_text_error_password_input)

            textInputPassword.error = passwordErrorText
        }else if(!confirmPasswordIsCorrect){
            textInputPassword.error = null

            val confirmPasswordErrorText = resources
                .getString(com.example.core.app.R.string.presentation_text_error_confirm_password_input)

            textInputPasswordConfirm.error = confirmPasswordErrorText
        }else{

            signUpButton.isEnabled = true

        }
    }

    private fun showLoading(show: Boolean) = with(binding) {

        if (show){
            signUpButton.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }else {
            signUpButton.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }

    }

    private fun showError(){

        BaseAlertDialog(
            hasOneAction = true
        )
            .show(parentFragmentManager,"")

    }

}