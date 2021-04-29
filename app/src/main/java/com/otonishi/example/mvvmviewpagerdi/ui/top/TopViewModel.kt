package com.otonishi.example.mvvmviewpagerdi.ui.top

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otonishi.example.mvvmviewpagerdi.R
import com.otonishi.example.mvvmviewpagerdi.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userRepository: UserRepository,
) : ViewModel() {

    private var callback: TopNavigator? = null
    val titleObservable = ObservableField<String>()
    val authorNameObservable = ObservableField<String>()

    fun setTopTitle() {
        titleObservable.set(context.resources.getString(R.string.top_title))
    }

    fun setCallback(callback: TopNavigator){
        this.callback = callback
    }

    fun onClickToViewPager() {
        callback?.toViewPager()
    }

    fun setAuthorName(){
        viewModelScope.launch {
            userRepository.onGetGithubUser({
                authorNameObservable.set(context.resources.getString(R.string.top_author, it.login))
            },{
                authorNameObservable.set("???")
            })
        }
    }
}