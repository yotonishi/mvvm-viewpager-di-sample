package com.otonishi.example.mvvmviewpagerdi.ui.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageCollectionAdapter(
    fragmentActivity: FragmentActivity,
    private val itemList: List<Fragment>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = itemList.size

    override fun createFragment(position: Int): Fragment = itemList[position]
}