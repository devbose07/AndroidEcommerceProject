package com.example.chetan.ecommerceproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.chetan.ecommerceproject.Dao.ItemInventoryDao;
import com.example.chetan.ecommerceproject.model.ItemCategory;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvViewShoppingCart = (TextView)findViewById(R.id.tvViewShoppingCart);
        SpannableString content = new SpannableString(getText(R.string.shopping_cart));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tvViewShoppingCart.setText(content);
        tvViewShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
                Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

         final ListView listview = (ListView) findViewById(R.id.lvCategories);
        final ArrayList<ItemCategory> itemCategories= ItemInventoryDao.intialiazeCategories();



        ArrayAdapter<ItemCategory> adapter = new ArrayAdapter<ItemCategory>(this, android.R.layout.simple_list_item_1, itemCategories);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ItemCategory itemCategory=ItemInventoryDao.intialiazeCategories().get(position);
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("itemCategory", itemCategory);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
