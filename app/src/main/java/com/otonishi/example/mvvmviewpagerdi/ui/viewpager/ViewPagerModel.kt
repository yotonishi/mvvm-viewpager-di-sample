package com.otonishi.example.mvvmviewpagerdi.ui.viewpager

import android.content.Context
import android.widget.RadioGroup
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.otonishi.example.mvvmviewpagerdi.R
import com.otonishi.example.mvvmviewpagerdi.extension.convertNumberToText
import com.otonishi.example.mvvmviewpagerdi.extension.selected1
import com.otonishi.example.mvvmviewpagerdi.extension.selected2
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class ViewPagerModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private var callback: ViewPagerNavigator? = null
    var selectedNumber = 0
    val inputText = ObservableField<String>()
    val errorText = ObservableField<String>()

    fun setCallback(callback: ViewPagerNavigator) {
        this.callback = callback
    }

    fun onClickToNext() {
        if (inputText.get()?.isNotEmpty() == true) {
            callback?.toNext()
        } else {
            errorText.set("Please input.")
        }
    }

    fun onClickToResult(rg: RadioGroup) {
        selectedNumber = when (rg.checkedRadioButtonId) {
            R.id.rg_view_pager_group_1 -> selected1
            R.id.rg_view_pager_group_2 -> selected2
            else -> throw Exception()
        }
        callback?.toResult()
    }

    fun getRadioText(number: Int): String {
        return context.convertNumberToText(number)
    }
}