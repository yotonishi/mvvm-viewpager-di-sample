package com.otonishi.example.mvvmviewpagerdi.ui.viewpager

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.otonishi.example.mvvmviewpagerdi.R
import com.otonishi.example.mvvmviewpagerdi.databinding.ActivityViewPagerBinding
import com.otonishi.example.mvvmviewpagerdi.extension.setupActionBar
import com.otonishi.example.mvvmviewpagerdi.ui.result.ResultActivity
import com.otonishi.example.mvvmviewpagerdi.ui.viewpager.page.PageOneFragment
import com.otonishi.example.mvvmviewpagerdi.ui.viewpager.page.PageTwoFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPagerActivity : AppCompatActivity(), ViewPagerNavigator {

    private lateinit var pageCollectionAdapter: PageCollectionAdapter
    private val viewPagerModel: ViewPagerModel by viewModels()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityViewPagerBinding>(
            this@ViewPagerActivity, R.layout.activity_view_pager
        )
    }

    private val fragmentList = listOf<Fragment>(
        PageOneFragment.newInstance(),
        PageTwoFragment.newInstance(),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        setupActionBar(binding.toolbar) {
            title = "Input Data"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        viewPagerModel.setCallback(this)
        initView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        if (binding.lyViewPager.currentItem == 0) {
            finish()
        } else {
            binding.lyViewPager.setCurrentItem(binding.lyViewPager.currentItem - 1, true)
        }
    }

    override fun toNext() {
        binding.lyViewPager.setCurrentItem(binding.lyViewPager.currentItem + 1, true)
    }

    override fun toResult() {
        startActivity(Intent(this, ResultActivity::class.java).apply {
            putExtra(ResultActivity.KeyInputText, viewPagerModel.inputText.get() ?: "")
            putExtra(ResultActivity.KeySelectedNumber, viewPagerModel.selectedNumber)
        })
        finish()
    }

    private fun initView() {
        initViewPager()
    }

    private fun initViewPager() {
        pageCollectionAdapter = PageCollectionAdapter(this, fragmentList)
        binding.lyViewPager.apply {
            isUserInputEnabled = false
            adapter = pageCollectionAdapter
        }
    }
}