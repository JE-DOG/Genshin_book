package com.example.feature.add.chat

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.core.app.ui.xml.base.BaseFragment
import com.example.core.app.delegate.viewBinding
import com.example.core.app.ui.xml.base.BaseAlertDialog
import com.example.core.app.navigation.ScreenProvider
import com.example.feature.add.chat.adapter.FindUsersAdapter
import com.example.feature.add.chat.databinding.FragmentAddChatBinding
import com.example.feature.add.chat.di.component.FeatureAddChatComponentViewModel
import com.example.feature.add.chat.vm.AddChatViewModel
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentAddChat: BaseFragment(R.layout.fragment_add_chat) {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var viewModelFactory: AddChatViewModel.Factory
    @Inject
    lateinit var screenProvider: ScreenProvider

    private val binding by viewBinding(FragmentAddChatBinding::bind)
    private val viewModel: AddChatViewModel by viewModels {
        viewModelFactory
    }
    lateinit var adapter: FindUsersAdapter

    override fun initUi(): Unit = with(binding) {

        lifecycleScope.launch(Dispatchers.Main) {

            viewModel.state.collect { state ->

                if (state.isError){
                    showErrorDialog()
                }

                state.chatId?.let { chatId ->
                    router.replaceScreen(
                        screenProvider.chat(
                            chatId
                        )
                    )
                }

                adapter.items = state.users.toMutableList()

                showLoading(state.isLoading)

            }

        }

        findUsersRcv.apply {

            adapter = this@FragmentAddChat.adapter

        }

        searchUsersByNickBut.apply {

            setOnClickListener {
                val userNick = inputUserNick.text.toString()

                viewModel.getUsersByNick(userNick)
            }

        }

    }

    private fun showLoading(show: Boolean): Unit = with(binding) {

        if (show){
            progressBar.visibility = View.VISIBLE

            findUsersRcv.visibility = View.GONE
        }else {
            findUsersRcv.visibility = View.VISIBLE

            progressBar.visibility = View.GONE
        }

    }

    private fun showErrorDialog(){

        BaseAlertDialog(
            onPositiveButtonClickListener = {
                viewModel.setErrorState(false)
            },
            hasOneAction = true
        )
            .show(parentFragmentManager,"")

    }

    override fun initDependencies() {

        adapter = FindUsersAdapter(
            onItemClickListener = { userId ->
                viewModel.addChatAndGetChatId(userId)
            }
        )

        val component = ViewModelProvider(this)[FeatureAddChatComponentViewModel::class.java].component
        component.inject(this)

    }

}