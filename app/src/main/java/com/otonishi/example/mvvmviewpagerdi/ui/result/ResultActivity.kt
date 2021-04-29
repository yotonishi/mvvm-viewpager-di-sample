package com.otonishi.example.mvvmviewpagerdi.ui.result

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.otonishi.example.mvvmviewpagerdi.R
import com.otonishi.example.mvvmviewpagerdi.databinding.ActivityResultBinding
import com.otonishi.example.mvvmviewpagerdi.databinding.ActivityViewPagerBinding
import com.otonishi.example.mvvmviewpagerdi.extension.setupActionBar
import com.otonishi.example.mvvmviewpagerdi.ui.top.TopViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultActivity: AppCompatActivity(), ResultNavigator {
    private val resultViewModel: ResultViewModel by viewModels()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityResultBinding>(
            this@ResultActivity, R.layout.activity_result
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setupActionBar(binding.toolbar) {
            title = "Result"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        resultViewModel.apply {
            setCallback(this@ResultActivity)
            setInputValue(this@ResultActivity.intent)
        }

        binding.viewmodel = resultViewModel
    }

    override fun finishResult() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val KeyInputText = "key_input_text"
        const val KeySelectedNumber = "key_selected_number"
    }
}