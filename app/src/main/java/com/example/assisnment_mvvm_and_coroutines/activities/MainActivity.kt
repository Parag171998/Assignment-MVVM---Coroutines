package com.example.assisnment_mvvm_and_coroutines.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assisnment_mvvm_and_coroutines.adapter.PhotosAdapter
import com.example.assisnment_mvvm_and_coroutines.R
import com.example.assisnment_mvvm_and_coroutines.models.Photo
import com.example.assisnment_mvvm_and_coroutines.models.Photos
import com.example.assisnment_mvvm_and_coroutines.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: PhotosAdapter
    private var photoList: ArrayList<Photos> = ArrayList()
    private val mainViewModel: MainViewModel by viewModel()
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        setRefresh()
    }

    private fun setRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            photoList.clear()
            adapter.notifyDataSetChanged()
            initViewModel()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun initViewModel() {
        coroutineScope.launch {
            val photos = getPhotoList()
            if(!photos.isNullOrEmpty()){
                photoList = photos as ArrayList<Photos>
            }
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = linearLayoutManager
        adapter = PhotosAdapter(this@MainActivity, photoList)
        recyclerView.adapter = adapter
        progressBar.visibility = View.GONE
    }

    private suspend fun getPhotoList(): List<Photos>? = withContext(Dispatchers.IO) {
        mainViewModel.getPhotos()?.body()?.photo?.photo
    }
}