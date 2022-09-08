package com.example.devapp.BucketList.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devapp.BucketList.Model.BucketListEntry;
import com.example.devapp.R;

import java.util.ArrayList;

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.BucketListViewHolder> {
    BucketListEntry[] entries;

    public BucketListAdapter(BucketListEntry[] entries) {
        this.entries = entries;
    }

    @NonNull
    @Override
    public BucketListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_bucketlist_items, parent, false);
        return new BucketListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketListViewHolder holder, int position) {
        holder.bind(entries[position], position);
    }

    @Override
    public int getItemCount() {
        return entries.length;
    }

    public static class BucketListViewHolder extends RecyclerView.ViewHolder{
        private TextView bucketListTitle, bucketListDesc;
        private ImageView bucketListImage;
        private RatingBar bucketListRating;

        public BucketListViewHolder(@NonNull View itemView) {
            super(itemView);

            bucketListTitle = itemView.findViewById(R.id.bucket_list_title);
            bucketListDesc = itemView.findViewById(R.id.bucket_list_description);
            bucketListImage = itemView.findViewById(R.id.bucket_list_image);
            bucketListRating = itemView.findViewById(R.id.bucket_list_rating);
        }

        public void bind(BucketListEntry entries, int position) {
            String title = position + 1 + ". " + entries.getTitle();
            bucketListTitle.setText(title);
            bucketListDesc.setText(entries.getDescription());
            bucketListImage.setImageResource(entries.getImage());
            bucketListRating.setRating(entries.getRating());
        }
    }
}
