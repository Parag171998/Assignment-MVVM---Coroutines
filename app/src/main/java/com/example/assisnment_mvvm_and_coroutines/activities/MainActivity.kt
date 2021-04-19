package com.example.assisnment_mvvm_and_coroutines.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assisnment_mvvm_and_coroutines.Adapter.TabAdapter
import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.R
import com.example.assisnment_mvvm_and_coroutines.viewModel.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private var albumList: List<Album>? = null
    private val mainViewModel: MainViewModel by viewModel()
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var adapter: TabAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initTableLayoutListener()
    }

    private fun initTableLayoutListener() {
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun initViewModel() {
//        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        mainViewModel?.init()

        coroutineScope.launch {
            albumList = getArticleList()
            setUpTableLayout()
        }

    }

    private fun setUpTableLayout() {
        for (album in albumList!!) {
            tabLayout.addTab(tabLayout.newTab().setText(album.title))
        }
        adapter = TabAdapter(supportFragmentManager, tabLayout.tabCount, albumList!!)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 1
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
    }

    private suspend fun getArticleList(): List<Album>? = withContext(Dispatchers.IO){
        mainViewModel.getAlbums()?.body()
    }
}