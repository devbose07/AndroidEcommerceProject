package com.example.chetan.ecommerceproject.model;

import java.io.Serializable;

/**
 * Created by chetan on 13/6/16.
 */
public class ItemCategory implements Serializable {
    public static final String TAG = ItemCategory.class.getSimpleName();

    public ItemCategory(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public static final String TABLE = "ItemCategory";
    // Labels Table Columns names
    @Override
    public String toString() {
        return  categoryName;
    }public static final String KEY_CategoryId = "categoryId";
    public static final String KEY_CategoryName = "categoryName";
    private int categoryId;
    private String categoryName;
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
