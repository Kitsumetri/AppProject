package com.example.applicationproject;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private final List<ProductData> mData;
    private final LayoutInflater mInflater;

    ProductAdapter(Context context, @NonNull List<ProductData> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductData productData = mData.get(position);

        holder.myTextViewName.setText(productData.getName());
        // holder.bg.setLayoutDirection(position);
        holder.myTextViewDescription.setText(productData.getDescription());
        if(position %2 == 1)
        {
            Picasso.get().load("https://i.imgur.com/fkTLdcJ.png").into(holder.imageView);
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            Picasso.get().load("https://i.imgur.com/0Ek5uIJ.png").into(holder.imageView);
            holder.itemView.setBackgroundColor(Color.parseColor("#BBBBBB"));
            //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextViewName;
        TextView myTextViewDescription;
        ImageView imageView;
        ViewHolder(View itemView) {
            super(itemView);
            myTextViewName = itemView.findViewById(R.id.textViewName);
            myTextViewDescription = itemView.findViewById(R.id.textViewDescription);
            imageView = itemView.findViewById(R.id.image_for_row);

        }
    }
}
