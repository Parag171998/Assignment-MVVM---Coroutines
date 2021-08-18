package com.example.assisnment_mvvm_and_coroutines.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assisnment_mvvm_and_coroutines.R
import com.example.assisnment_mvvm_and_coroutines.adapter.PhotosAdapter
import com.example.assisnment_mvvm_and_coroutines.models.Hit
import com.example.assisnment_mvvm_and_coroutines.viewModel.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.image_layout.*
import kotlinx.android.synthetic.main.image_layout.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(), PhotosAdapter.OnImageClick {
    private var adapter: PhotosAdapter? = null
    private var photoList: ArrayList<Hit> = ArrayList()
    private val mainViewModel: MainViewModel by viewModel()
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.toString().trim().isNotEmpty()){
                    initViewModel(newText.toString())
                }
                else{
                    initViewModel("yellow+flowers")
                }
                return false
            }

        })
        initViewModel("yellow+flowers")
    }

    private fun initViewModel(value: String) {
        coroutineScope.launch {
            val photos = getPhotoList(value)
            photoList.clear()
            if(!photos.isNullOrEmpty()) {
                photoList.addAll(photos as ArrayList<Hit>)
            }
            if(adapter == null) {
                initRecyclerView()
            }
            else{
                adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = linearLayoutManager
        adapter = PhotosAdapter(this@MainActivity, photoList, this)
        recyclerView.adapter = adapter
        progressBar.visibility = View.GONE
    }

    private suspend fun getPhotoList(value: String): List<Hit?>? = withContext(Dispatchers.IO) {
        mainViewModel.getPhotos(value)?.body()?.getHits()
    }

    @SuppressLint("InflateParams")
    override fun onImageClick(position: Int) {
        val intent = Intent(applicationContext, FullScreenImage::class.java)
        intent.putExtra("url", photoList[position].getLargeImageURL())
        startActivity(intent)
    }
}