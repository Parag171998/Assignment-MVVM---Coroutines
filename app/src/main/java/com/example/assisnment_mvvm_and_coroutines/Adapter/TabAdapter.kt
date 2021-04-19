package com.example.assisnment_mvvm_and_coroutines.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.fragments.DynamicFragment

class TabAdapter(fm: FragmentManager, var mNumOfTabs: Int, private val albumList: List<Album>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return DynamicFragment(
            albumList[position]
        )
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }

}