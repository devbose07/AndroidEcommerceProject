package com.example.chetan.ecommerceproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chetan.ecommerceproject.Dao.ItemInventoryDao;
import com.example.chetan.ecommerceproject.adapter.ItemInventoryAdapter;
import com.example.chetan.ecommerceproject.model.ItemCategory;
import com.example.chetan.ecommerceproject.model.ItemInventory;


public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category);
        Bundle data = getIntent().getExtras();
        final ItemCategory itemCategory = (ItemCategory) data.getSerializable("itemCategory");
        TextView tvViewShoppingCart = (TextView)findViewById(R.id.tvViewShoppingCart1);
        SpannableString content = new SpannableString(getText(R.string.shopping_cart));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tvViewShoppingCart.setText(content);
        tvViewShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        ListView lvProducts = (ListView) findViewById(R.id.lvProducts);
        lvProducts.addHeaderView(getLayoutInflater().inflate(R.layout.product_list_header, lvProducts, false));

        ItemInventoryAdapter productAdapter = new ItemInventoryAdapter(this);

        productAdapter.updateProducts(ItemInventoryDao.intialiazeItemsByCategory(itemCategory));
        lvProducts.setAdapter(productAdapter);
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ItemInventory itemInventory=ItemInventoryDao.intialiazeItemsByCategory(itemCategory).get(position - 1);
                Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("itemInventory", itemInventory);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }




}