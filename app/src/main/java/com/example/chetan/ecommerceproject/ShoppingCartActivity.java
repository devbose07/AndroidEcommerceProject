package com.example.chetan.ecommerceproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;


import com.example.chetan.ecommerceproject.adapter.CartItemAdapter;
import com.example.chetan.ecommerceproject.constant.Constant;
import com.example.chetan.ecommerceproject.model.Cart;
import com.example.chetan.ecommerceproject.model.CartItem;
import com.example.chetan.ecommerceproject.model.ItemInventory;
import com.example.chetan.ecommerceproject.util.CartHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ShoppingCartActivity extends AppCompatActivity {
    private static final String TAG = "ShoppingCartActivity";

    ListView lvCartItems;
    Button bClear;
    Button bShop;
    TextView tvTotalPrice;
    CheckBox checkBox ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        lvCartItems = (ListView) findViewById(R.id.lvCartItems);
        LayoutInflater layoutInflater = getLayoutInflater();

        final Cart cart = CartHelper.getCart();
        final TextView tvTotalPrice = (TextView) findViewById(R.id.tvTotalPrice);
        tvTotalPrice.setText(Constant.CURRENCY+String.valueOf(cart.getTotalPrice().setScale(2, BigDecimal.ROUND_HALF_UP)));

        lvCartItems.addHeaderView(layoutInflater.inflate(R.layout.cart_header, lvCartItems, false));

        final CartItemAdapter cartItemAdapter = new CartItemAdapter(this,getCartItems(cart).toArray());

        cartItemAdapter.updateCartItems(getCartItems(cart));

        lvCartItems.setAdapter(cartItemAdapter);


        bClear = (Button) findViewById(R.id.bClear);
        bShop = (Button) findViewById(R.id.bShop);

        bClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              List <CartItem> cartItemList=getCartItems(cart);
                int counter=0;
                int j=0;
               for(int currentPos=0;currentPos<cartItemList.size();currentPos++)
                {


                    if(cartItemAdapter.mCheckStates.get(currentPos)) {
                        int iterator=CartHelper.determinePositionOfItem(counter,currentPos);
                        cart.remove(getCartItems(cart).get(iterator).getItemInventory());
                        counter=counter+1;
                    }
                    }

                cartItemAdapter.updateCartItems(getCartItems(cart));
                cartItemAdapter.notifyDataSetChanged();
               tvTotalPrice.setText(Constant.CURRENCY+String.valueOf(cart.getTotalPrice().setScale(2, BigDecimal.ROUND_HALF_UP)));
       }
        });

        bShop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<CartItem> getCartItems(Cart cart) {
        List<CartItem> cartItems = new ArrayList<CartItem>();
        Log.d(TAG, "Current shopping cart: " + cart);

        Map<ItemInventory, Integer> itemMap = (Map<ItemInventory, Integer>) cart.getItemWithQuantity();

        for (Entry<ItemInventory, Integer> entry : itemMap.entrySet()) {
            CartItem cartItem = new CartItem();
            cartItem.setItemInventory((ItemInventory) entry.getKey());

            cartItem.setQuantity(entry.getValue());
            cartItems.add(cartItem);
        }

        Log.d(TAG, "Cart item list: " + cartItems);
        return cartItems;
    }
}
