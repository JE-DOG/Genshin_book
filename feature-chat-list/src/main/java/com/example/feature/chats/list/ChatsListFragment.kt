package com.example.feature.chats.list

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.core.app.base.BaseFragment
import com.example.core.app.delegate.viewBinding
import com.example.core.app.elements.xml.BaseErrorAlertDialog
import com.example.core.app.navigation.ScreenProvider
import com.example.feature.chats.list.adapter.ChatsListAdapter
import com.example.feature.chats.list.vm.ChatsListViewModel
import com.example.feature.chats.list.vm.ChatsListViewState
import com.example.feature.chats.list.di.component.FeatureChatsListComponentViewModel
import com.example.feature_chats_list.R
import com.example.feature_chats_list.databinding.FragmentChatsListBinding
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatsListFragment: BaseFragment(R.layout.fragment_chats_list) {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screenProvider: ScreenProvider
    @Inject
    lateinit var viewModel: ChatsListViewModel

    private val binding by viewBinding(FragmentChatsListBinding::bind)
    private lateinit var adapter: ChatsListAdapter

    override fun initUi(): Unit = with(binding) {

        userChatsListRcv.apply {
            adapter = this@ChatsListFragment.adapter
        }

        lifecycleScope.launch(Dispatchers.Main) {

            viewModel.state.collect {

                if (it.isError){
                    showErrorAlertDialog()
                }

                setLoadingVisible(it.isLoading)

                Log.d("UpdateTag",it.chats.toString())

                adapter.items = it.chats.toMutableList()

            }

        }

        addChatBut.apply {

            setOnClickListener {
                router.navigateTo(
                    screenProvider.addChat()
                )
            }

        }

    }

    private fun showErrorAlertDialog(){
        BaseErrorAlertDialog(
            onPositiveButtonClickListener = {
                viewModel.getChats()
            },
            onNegativeButtonClickListener = {
                viewModel.setState(
                    ChatsListViewState(
                        isError = true
                    )
                )
            }
        ).show(requireActivity().supportFragmentManager,"")
    }

    private fun setLoadingVisible(show: Boolean): Unit = with(binding){
        if (show){
            progressBar.visibility = View.VISIBLE
            userChatsListRcv.visibility = View.GONE
        }else{
            progressBar.visibility = View.GONE
            userChatsListRcv.visibility = View.VISIBLE
        }
    }

    override fun initDependencies() {

        val component = ViewModelProvider(this)[FeatureChatsListComponentViewModel::class.java].component
        component.inject(this)

        adapter = ChatsListAdapter (
            onItemClickListener = { chatId ->
                router.navigateTo(
                    screenProvider.chat(chatId)
                )
            }
        )

    }

}

