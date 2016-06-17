package com.example.chetan.ecommerceproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.chetan.ecommerceproject.R;
import com.example.chetan.ecommerceproject.constant.Constant;
import com.example.chetan.ecommerceproject.model.ItemInventory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ItemInventoryAdapter extends BaseAdapter {
    private static final String TAG = "ItemInventoryAdapter";


    private List<ItemInventory> products = new ArrayList<ItemInventory>();

    private final Context context;

    public ItemInventoryAdapter(Context context) {
        this.context = context;
    }

    public void updateProducts(List<ItemInventory> products) {
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public ItemInventory getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tvName;
        TextView tvPrice;
        ImageView ivImage;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.adapter_product, parent, false);
            tvName = (TextView) convertView.findViewById(R.id.tvProductName);
            tvPrice = (TextView) convertView.findViewById(R.id.tvProductPrice);
            ivImage = (ImageView) convertView.findViewById(R.id.ivProductImage);
            convertView.setTag(new ViewHolder(tvName, tvPrice, ivImage));
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            tvName = viewHolder.tvProductName;
            tvPrice = viewHolder.tvProductPrice;
            ivImage = viewHolder.ivProductImage;
        }

        final ItemInventory itemInventory = getItem(position);
        tvName.setText(itemInventory.getName());
        tvPrice.setText(Constant.CURRENCY+String.valueOf(itemInventory.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP)));
        Log.d(TAG, "Context package name: " + context.getPackageName());
        ivImage.setImageResource(context.getResources().getIdentifier(
                itemInventory.getImageUrl1(), "drawable", context.getPackageName()));
        return convertView;
    }

    private static class ViewHolder {
        public final TextView tvProductName;
        public final TextView tvProductPrice;
        public final ImageView ivProductImage;

        public ViewHolder(TextView tvProductName, TextView tvProductPrice, ImageView ivProductImage) {
            this.tvProductName = tvProductName;
            this.tvProductPrice = tvProductPrice;
            this.ivProductImage = ivProductImage;
        }
    }
}
