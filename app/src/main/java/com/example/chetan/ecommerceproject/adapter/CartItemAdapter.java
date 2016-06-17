package com.example.chetan.ecommerceproject.adapter;

import android.content.Context;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.example.chetan.ecommerceproject.R;
import com.example.chetan.ecommerceproject.constant.Constant;
import com.example.chetan.ecommerceproject.model.Cart;
import com.example.chetan.ecommerceproject.model.CartItem;
import com.example.chetan.ecommerceproject.util.CartHelper;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;


public class CartItemAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "CartItemAdapter";
    public SparseBooleanArray mCheckStates;

    CheckBox checkBox ;
    private List<CartItem> cartItems = Collections.emptyList();

    private final Context context;

    public CartItemAdapter(Context context,Object[] data) {
        this.context = context;
        mCheckStates = new SparseBooleanArray(data.length);
    }

    public void updateCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
        for(CartItem i:cartItems) {
            Log.d("InUpdate", i.getItemInventory().getName());
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }

    @Override
    public CartItem getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView tvName;
        TextView tvUnitPrice;
        TextView tvQuantity;
        TextView tvPrice;
        ViewHolder viewHolder=null;
        if (convertView == null) {

            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.adapter_cart_item, parent, false);
            checkBox = (CheckBox) convertView.findViewById(R.id.checkBox1);
            tvName = (TextView) convertView.findViewById(R.id.tvCartItemName);
            tvUnitPrice = (TextView) convertView.findViewById(R.id.tvCartItemUnitPrice);
            tvQuantity = (TextView) convertView.findViewById(R.id.tvCartItemQuantity);
            tvPrice = (TextView) convertView.findViewById(R.id.tvCartItemPrice);
            convertView.setTag(new ViewHolder(tvName, tvUnitPrice, tvQuantity, tvPrice,checkBox));
            viewHolder = new ViewHolder(tvName,tvUnitPrice,tvQuantity,tvPrice,checkBox);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            tvName = viewHolder.tvCartItemName;
            tvUnitPrice = viewHolder.tvCartItemUnitPrice;
            tvQuantity = viewHolder.tvCartItemQuantity;
            tvPrice = viewHolder.tvCartItemPrice;
         checkBox=viewHolder.checkBox;
        }


        Cart cart = CartHelper.getCart();
        final CartItem cartItem = getItem(position);
        tvName.setText(cartItem.getItemInventory().getName());
        tvUnitPrice.setText(Constant.CURRENCY+String.valueOf(cartItem.getItemInventory().getPrice().setScale(2, BigDecimal.ROUND_HALF_UP)));
        tvQuantity.setText(String.valueOf(cartItem.getQuantity()));
        tvPrice.setText(Constant.CURRENCY+String.valueOf(cart.getCost(cartItem.getItemInventory()).setScale(2, BigDecimal.ROUND_HALF_UP)));
        viewHolder.checkBox.setTag(position);
        viewHolder.checkBox.setChecked(mCheckStates.get(position, false));
        viewHolder.checkBox.setOnCheckedChangeListener(this);

//        checkBox.setTag(cartItem);
        return convertView;
    }

    public boolean isChecked(int position) {

        return mCheckStates.get(position, false);
    }

    public void setChecked(int position, boolean isChecked) {
        mCheckStates.put(position, isChecked);

    }

    public void toggle(int position) {
        setChecked(position, !isChecked(position));

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mCheckStates.put((Integer) buttonView.getTag(), isChecked);

    }

    static class ViewHolder {
        public final TextView tvCartItemName;
        public final TextView tvCartItemUnitPrice;
        public final TextView tvCartItemQuantity;
        public final TextView tvCartItemPrice;
        public  CheckBox checkBox ;

        public ViewHolder(TextView tvCartItemName, TextView tvCartItemUnitPrice, TextView tvCartItemQuantity, TextView tvCartItemPrice,CheckBox checkBox) {
            this.tvCartItemName = tvCartItemName;
            this.tvCartItemUnitPrice = tvCartItemUnitPrice;
            this.tvCartItemQuantity = tvCartItemQuantity;
            this.tvCartItemPrice = tvCartItemPrice;
            this.checkBox = checkBox;
        }
    }
}
