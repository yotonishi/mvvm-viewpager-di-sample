package com.otonishi.example.mvvmviewpagerdi.ui.top

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.otonishi.example.mvvmviewpagerdi.R
import com.otonishi.example.mvvmviewpagerdi.databinding.ActivityTopBinding
import com.otonishi.example.mvvmviewpagerdi.extension.setupActionBar
import com.otonishi.example.mvvmviewpagerdi.ui.viewpager.ViewPagerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopActivity : AppCompatActivity(), TopNavigator {
    private val topViewModel: TopViewModel by viewModels()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityTopBinding>(
            this@TopActivity, R.layout.activity_top
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)

        setupActionBar(binding.toolbar) {
            title = resources.getString(R.string.app_name)
        }

        binding.viewmodel = topViewModel
        topViewModel.setTopTitle()
        topViewModel.setCallback(this)
        topViewModel.setAuthorName()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun toViewPager() {
        startActivity(Intent(this, ViewPagerActivity::class.java))
    }
}