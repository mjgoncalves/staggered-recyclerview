package com.example.marcelo.staggeredrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "StaggeredRecyclerViewAd";
    private Context context;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    StaggeredRecyclerViewAdapter(Context context, ArrayList<String> mImageUrls, ArrayList<String> mNames) {
        this.context = context;
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.griditem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: called!");
        
        final int POS = holder.getAdapterPosition();
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(context)
                .load(mImageUrls.get(position))
                .apply(requestOptions)
                .into(holder.image);

        holder.name.setText(mNames.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked!");
                Toast.makeText(context, mNames.get(POS), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageViewWidget);
            name = itemView.findViewById(R.id.nameWidget);
        }
    }
}


