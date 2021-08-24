package com.example.viewpager_20210824.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewpager_20210824.fragments.BirthYearFragment
import com.example.viewpager_20210824.fragments.HelloFragment
import com.example.viewpager_20210824.fragments.NameFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> "인사"
        1 -> "이름"
        else -> "출생년도"
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> HelloFragment()
        1 -> NameFragment()
        else -> BirthYearFragment()
    }
}