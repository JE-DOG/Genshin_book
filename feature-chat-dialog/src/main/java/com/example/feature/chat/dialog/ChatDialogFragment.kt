package com.example.feature.chat.dialog

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.core.app.base.BaseFragment
import com.example.core.app.delegate.viewBinding
import com.example.core.app.elements.xml.BaseAlertDialog
import com.example.core.app.navigation.ScreenProvider
import com.example.feature.chat.dialog.adapter.DialogAdapter
import com.example.feature.chat.dialog.databinding.FragmentChatDialogBinding
import com.example.feature.chat.dialog.di.component.FeatureChatDialogViewModel
import com.example.feature.chat.dialog.vm.ChatDialogViewModel
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatDialogFragment: BaseFragment(R.layout.fragment_chat_dialog) {

    @Inject
    lateinit var viewModelFactory: ChatDialogViewModel.Factory.DaggerFactory
    @Inject
    lateinit var adapter: DialogAdapter
    @Inject
    lateinit var router: Router

    private val viewModel: ChatDialogViewModel by viewModels {
        val chatId = requireArguments().getString(ScreenProvider.CHAT_ID_KEY) ?: ""
        viewModelFactory.create(chatId)
    }
    private val binding by viewBinding(FragmentChatDialogBinding::bind)

    override fun initDependencies() {

        val component = ViewModelProvider(this)[FeatureChatDialogViewModel::class.java]
            .component
        component.inject(this)
        Log.d("TestTag","Injected")

    }

    override fun initUi(): Unit = with(binding) {



        lifecycleScope.launch(Dispatchers.Main) {
            
            viewModel.state.collect { state ->

                adapter.items = state.messages.toMutableList()

                Log.d("UpdateTag","From state observe ->" + state.messages.toString())

                if (state.isError)
                    showError()

                showLoading(state.isLoading)

                state.profile?.let {  profile ->

                    userAvatarImg.load(profile.avatar) {
                        this.placeholder(com.example.core.app.R.drawable.ic_default_user_avatar)
                    }

                    userFullNameText.text = profile.fullName

                }

            }

        }

        dialogRcv.apply {

            adapter = this@ChatDialogFragment.adapter

        }

        sendMessageBut.apply {

            setOnClickListener {
                val textMessage = inputMessage.text.toString()
                viewModel.sendMessage(textMessage)
                inputMessage.setText("")

            }

        }
        
    }

    private fun showError(){
        BaseAlertDialog(
            onPositiveButtonClickListener = {
                viewModel.getChatMessages()
            },
            onNegativeButtonClickListener = {
                router.exit()
            }
        )
    }

    private fun showLoading(
        isLoading: Boolean
    ) = with(binding) {

        if (isLoading){
            progressBar.visibility = View.VISIBLE
        }else {
            progressBar.visibility = View.GONE
        }

    }

}