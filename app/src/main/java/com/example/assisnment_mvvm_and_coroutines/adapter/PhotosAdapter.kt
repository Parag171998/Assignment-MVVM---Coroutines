package com.example.assisnment_mvvm_and_coroutines.adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.example.assisnment_mvvm_and_coroutines.R
import com.example.assisnment_mvvm_and_coroutines.models.Hit
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_layout.*


class PhotosAdapter(context: Context, private var resultList: List<Hit>, private val onImageClick: OnImageClick) :
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.recycler_grid_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(resultList[position].getLargeImageURL()).into(holder.artistImg)
        holder.artistImg.setOnClickListener {
            onImageClick.onImageClick(position)
        }
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var artistImg: ImageView = itemView.findViewById(R.id.img)
    }

    interface OnImageClick{
        fun onImageClick(position: Int)
    }
}