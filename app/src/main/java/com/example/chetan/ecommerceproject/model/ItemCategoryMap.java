package com.example.chetan.ecommerceproject.model;

/**
 * Created by chetan on 13/6/16.
 */
public class ItemCategoryMap {

    public static final String TAG = ItemCategoryMap.class.getSimpleName();
    public static final String TABLE = "itemCategoryMap";
    // Labels Table Columns names
    public static final String KEY_ItemCode = "itemCode";
    public static final String KEY_CategoryId = "categoryId";

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    private String itemCode;
    private int categoryId;

}
