package com.example.viewpager_20210824.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewpager_20210824.fragments.BirthYearFragment
import com.example.viewpager_20210824.fragments.HelloFragment
import com.example.viewpager_20210824.fragments.NameFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        if (position == 0) {
            return HelloFragment()
        } else if (position == 1) {
            return NameFragment()
        } else{
            return BirthYearFragment()
        }
    }
}