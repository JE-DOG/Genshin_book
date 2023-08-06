package com.example.feature.add.chat

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.core.app.base.BaseFragment
import com.example.core.app.delegate.viewBinding
import com.example.core.app.elements.xml.BaseErrorAlertDialog
import com.example.core.app.navigation.ScreenProvider
import com.example.core.ext.isNotNull
import com.example.feature.add.chat.adapter.FindUsersAdapter
import com.example.feature.add.chat.databinding.FragmentAddChatBinding
import com.example.feature.add.chat.di.component.FeatureAddChatComponentViewModel
import com.example.feature.add.chat.vm.AddChatViewModel
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentAddChat: BaseFragment(R.layout.fragment_add_chat) {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var viewModel: AddChatViewModel
    @Inject
    lateinit var screenProvider: ScreenProvider

    private val binding by viewBinding(FragmentAddChatBinding::bind)
    lateinit var adapter: FindUsersAdapter

    override fun initUi(): Unit = with(binding) {

        lifecycleScope.launch(Dispatchers.Main) {

            viewModel.state.collect {

                if (it.isError){
                    showErrorDialog()
                }

                it.chatId?.let { chatId ->
                    router.replaceScreen(
                        screenProvider.chat(
                            chatId
                        )
                    )
                }


            }

        }



    }

    private fun showErrorDialog(){

        BaseErrorAlertDialog(
            onPositiveButtonClickListener = {
                viewModel.setErrorState(false)
            },
            hasOneAction = true
        ).show(parentFragmentManager,"")

    }

    override fun initDependencies() {

        adapter = FindUsersAdapter(
            onItemClickListener = { chatId ->
                router.navigateTo(
                    screenProvider.chat(chatId)
                )
            }
        )

        val component = ViewModelProvider(this)[FeatureAddChatComponentViewModel::class.java].component
        component.inject(this)

    }

}