package com.otonishi.example.mvvmviewpagerdi.ui.result

import android.content.Context
import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.otonishi.example.mvvmviewpagerdi.extension.convertNumberToText
import com.otonishi.example.mvvmviewpagerdi.extension.selected1
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private var callback: ResultNavigator? = null
    val inputText = ObservableField<String>()
    val selectedRadioText = ObservableField<String>()

    fun setCallback(callback: ResultNavigator) {
        this.callback = callback
    }

    fun setInputValue(intent: Intent) {
        inputText.set(intent.getStringExtra(ResultActivity.KeyInputText))
        context.convertNumberToText(intent.getIntExtra(ResultActivity.KeySelectedNumber, selected1))
            .also {
                selectedRadioText.set(it)
            }
    }

    fun onClickFinish() {
        callback?.finishResult()
    }
}