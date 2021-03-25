package com.example.assisnment_mvvm_and_coroutines.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assisnment_mvvm_and_coroutines.R;
import com.example.assisnment_mvvm_and_coroutines.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {

    LayoutInflater layoutInflater;
    List<Photo> resultList;
    Context context;
    public PhotosAdapter(Context context, List<Photo> resultList) {
        this.context = context;
        this.layoutInflater = layoutInflater.from(context);
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =layoutInflater.inflate(R.layout.recycler_grid_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.ViewHolder holder, int position) {
        Picasso.get().load(resultList.get(position).getUrl()).into(holder.artistImg);
        holder.name.setText(resultList.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView artistImg;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            artistImg = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }

}
