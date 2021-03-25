package com.example.assisnment_mvvm_and_coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assisnment_mvvm_and_coroutines.Adapter.PhotosAdapter
import com.example.assisnment_mvvm_and_coroutines.models.Photo
import com.example.assisnment_mvvm_and_coroutines.network.ApiClient
import kotlinx.android.synthetic.main.fragment_dynamic.*
import kotlinx.android.synthetic.main.fragment_dynamic.view.*
import kotlinx.coroutines.*

class DynamicFragment(private val album: Album) : Fragment() {
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dynamic, container, false)
        coroutineScope.launch{
            val photoList = getPhotoList()
            val gridLayoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)

            view.recyclerView.layoutManager = gridLayoutManager
            val adapter = PhotosAdapter(context, photoList)
            view.recyclerView.adapter = adapter
            progressBar.visibility = View.GONE
        }

        return view
    }

    private suspend fun getPhotoList(): List<Photo>? = withContext(Dispatchers.IO){
        ApiClient.instance?.api?.getPhotos(album.id.toString())?.body()
    }
}