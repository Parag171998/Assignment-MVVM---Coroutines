package com.example.assisnment_mvvm_and_coroutines.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assisnment_mvvm_and_coroutines.R
import com.example.assisnment_mvvm_and_coroutines.models.Photos
import com.squareup.picasso.Picasso

class PhotosAdapter(context: Context, private var resultList: List<Photos>) :
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.recycler_grid_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(resultList[position].urlQ).into(holder.artistImg)
        holder.name.text = resultList[position].title
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var artistImg: ImageView = itemView.findViewById(R.id.img)
        var name: TextView = itemView.findViewById(R.id.name)

    }

}