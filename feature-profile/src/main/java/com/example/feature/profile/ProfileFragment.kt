package com.example.feature.profile

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.core.app.base.BaseFragment
import com.example.core.app.delegate.viewBinding
import com.example.core.app.elements.xml.BaseAlertDialog
import com.example.core.app.navigation.ScreenProvider
import com.example.core.ext.isNotNull
import com.example.feature.profile.databinding.FragmentProfileBinding
import com.example.feature.profile.di.vm.FeatureProfileDepsViewModel
import com.example.feature.profile.vm.ProfileViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ProfileFragment: BaseFragment(R.layout.fragment_profile) {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screenProvider: ScreenProvider
    @Inject
    lateinit var viewModelFactory: ProfileViewModel.Factory

    private val viewModel: ProfileViewModel by viewModels {
        viewModelFactory
    }
    private val binding by viewBinding(FragmentProfileBinding::bind)

    override fun initDependencies() {

        ViewModelProvider(this)[FeatureProfileDepsViewModel::class.java]
            .component
            .inject(this)
    }

    override fun initUi(): Unit = with(binding) {

        errorLayout.apply {

            repeatTry.apply {

                setOnClickListener {

                    errorLayout.root.visibility = View.GONE
                    viewModel.getProfile()

                }

            }

        }

    }

    override suspend fun observeState() = with(binding) {

        viewModel.state.collect {

            showLoading(it.isLoading)

            if (it.isError){

                showError()
            }

            it.profile?.let { profile ->

                userFullNameTv.text = profile.fullName
                userAvatarImg.load(profile.avatar) {
                    placeholder(com.example.core.app.R.drawable.ic_default_user_avatar)
                }

            }

        }

    }

    private fun showLoading(show: Boolean) = with(binding) {

        if (show){
            progressBar.visibility = View.VISIBLE
            profileLayout.visibility = View.GONE
        }else {
            progressBar.visibility = View.GONE
            profileLayout.visibility = View.VISIBLE
        }

    }

    private fun showError() = with(binding) {

        BaseAlertDialog(
            onNegativeButtonClickListener = {
                errorLayout.root.visibility = View.VISIBLE
            },
            onPositiveButtonClickListener = {
                viewModel.getProfile()
            }
        )
            .show(parentFragmentManager,"")


    }

}