package com.example.chetan.ecommerceproject.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by chetan on 13/6/16.
 */
public class ItemInventory implements Serializable{
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private int itemId;
    private String itemCode;
    private String name;
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public ItemInventory(int itemId,String name, BigDecimal price,String description, String imageUrl1,String itemCode, String type,String supplier) {
        this.supplier = supplier;
        this.itemId = itemId;
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
        this.imageUrl1 = imageUrl1;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    private String description;
    private String type;
    private String imageUrl1;
    private String supplier;
    private BigDecimal price;



}



