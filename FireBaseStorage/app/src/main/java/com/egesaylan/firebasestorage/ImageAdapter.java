package com.egesaylan.firebasestorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.egesaylan.firebasestorage.Model.Upload;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private final Context context;
    private List<Upload> uploads;

    public ImageAdapter(Context context, List<Upload> uploads) {
        this.context = context;
        this.uploads = uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.image_item,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Upload uploadCurrent = uploads.get(position);
        holder.textviewname.setText(uploadCurrent.getName());
        Picasso.with(context)
                .load(uploadCurrent.getImageUrl())
                .fit()
                .centerCrop()
                .into(holder.imageview);
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textviewname;
        public ImageView imageview;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            textviewname = itemView.findViewById(R.id.textViewName);
            imageview = itemView.findViewById(R.id.itemImageView);
        }
    }
}
