package com.example.applicationproject;

import android.content.Context;
import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
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
    private final RecyclerViewClickListener listener;


    ProductAdapter(Context context, @NonNull List<ProductData> data, RecyclerViewClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.listener = listener;
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

        Picasso.get().load(productData.getItemSourceLink()).into(holder.imageView);
        holder.myTextViewName.setText(productData.getName());
        holder.myTextViewName.setMovementMethod(new ScrollingMovementMethod());

        String price = productData.getPrice() + " рублей";
        holder.myTextViewPrice.setText(price);
        holder.myTextViewPrice.setMovementMethod(new ScrollingMovementMethod());

        if (position % 2 == 1)
            holder.itemView.setBackgroundColor(Color.parseColor("#CDBFA8"));
        else
            holder.itemView.setBackgroundColor(Color.parseColor("#E9E4C6"));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, ProductData productData);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myTextViewName;
        TextView myTextViewPrice;

        ImageView imageView;
        ViewHolder(View itemView) {
            super(itemView);
            myTextViewName = itemView.findViewById(R.id.textViewName);
            myTextViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.image_for_row);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            listener.onClick(view, mData.get(getAdapterPosition()));
        }
    }
}