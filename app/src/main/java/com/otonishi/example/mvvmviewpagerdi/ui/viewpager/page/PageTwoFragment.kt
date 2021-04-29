package com.otonishi.example.mvvmviewpagerdi.ui.viewpager.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.otonishi.example.mvvmviewpagerdi.R
import com.otonishi.example.mvvmviewpagerdi.databinding.FragmentViewPager1Binding
import com.otonishi.example.mvvmviewpagerdi.databinding.FragmentViewPager2Binding
import com.otonishi.example.mvvmviewpagerdi.ui.viewpager.ViewPagerModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PageTwoFragment: Fragment() {
    private var binding: FragmentViewPager2Binding? = null

    // You can use activityViewModels to share a ViewModel with the parent Activity.
    private val viewPagerModel: ViewPagerModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val root = inflater.inflate(R.layout.fragment_view_pager_2, container, false)

        if (binding == null) {
            binding = FragmentViewPager2Binding.bind(root)
        }

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewmodel = this@PageTwoFragment.viewPagerModel
            radiogroup = this.rgViewPagerGroup
        }
    }

    companion object {
        fun newInstance() = PageTwoFragment()
    }
}