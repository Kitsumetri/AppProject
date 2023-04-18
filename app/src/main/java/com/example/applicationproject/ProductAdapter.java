package com.example.applicationproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> implements Filterable {
    private final ArrayList<ProductData> mData;
    private final LayoutInflater mInflater;
    private final RecyclerViewClickListener listener;
    private final ItemFilter itemFilter;
    private ArrayList<ProductData> filteredItemList;


    ProductAdapter(Context context, @NonNull ArrayList<ProductData> data, RecyclerViewClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.listener = listener;
        this.filteredItemList = mData;
        this.itemFilter = new ItemFilter();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductData productData = filteredItemList.get(position);
        Picasso.get().load(productData.getItemSourceLink()).into(holder.imageView,
                new Callback() {
                    @Override
                    public void onSuccess() {
                        Bitmap originalBitmap = ((BitmapDrawable) holder.imageView.getDrawable()).getBitmap();


                        Bitmap newBitmap = Bitmap.createBitmap(originalBitmap.getWidth(),
                                                                    originalBitmap.getHeight(),
                                                                    Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(newBitmap);
                        canvas.drawBitmap(originalBitmap, 0, 0, null);

                        for (int x = 0; x < newBitmap.getWidth(); x++)
                            for (int y = 0; y < newBitmap.getHeight(); y++) {
                                int pixel = newBitmap.getPixel(x, y);

                                if (Color.red(pixel) >= 245 &&
                                        Color.green(pixel) >= 245 &&
                                        Color.blue(pixel) >= 245)
                                        newBitmap.setPixel(x, y, Color.TRANSPARENT);
                                }
                        holder.imageView.setImageBitmap(newBitmap);
                    }
                    @Override
                    public void onError(Exception e) {}
                });


        holder.myTextViewName.setText(productData.getName());

        String price = productData.getPrice() + " рублей";
        holder.myTextViewPrice.setText(price);

        if (position % 2 == 1)
            holder.itemView.setBackgroundColor(Color.parseColor("#CDBFA8"));
        else
            holder.itemView.setBackgroundColor(Color.parseColor("#E9E4C6"));
    }

    @Override
    public int getItemCount() { return filteredItemList.size(); }

    @Override
    public Filter getFilter() { return itemFilter; }

    public interface RecyclerViewClickListener { void onClick(View v, ProductData productData); }

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
            listener.onClick(view, filteredItemList.get(getAdapterPosition()));
        }
    }
    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            ArrayList<ProductData> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0)
                filteredList.addAll(mData);
            else {
                String filterPattern = constraint.toString().trim();
                for (ProductData item : mData)
                    if (item.getName().contains(filterPattern))
                        filteredList.add(item);
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredItemList = (ArrayList<ProductData>) results.values;
            notifyDataSetChanged();
        }
    }
}