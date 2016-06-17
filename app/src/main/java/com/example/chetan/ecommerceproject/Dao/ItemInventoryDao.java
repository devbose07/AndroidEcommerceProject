package com.example.chetan.ecommerceproject.Dao;



import com.example.chetan.ecommerceproject.constant.Constant;
import com.example.chetan.ecommerceproject.model.ItemCategory;
import com.example.chetan.ecommerceproject.model.ItemInventory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chetan on 14/6/16.
 */
public class ItemInventoryDao {
    private ItemInventory itemInventory;

    public static List<ItemInventory> intialiazeItemsByCategory(ItemCategory itemCategory)
    {
        List<ItemInventory> itemInventoryList=new ArrayList<ItemInventory>();
        if(itemCategory.getCategoryId()== Constant.MOBILES)
        {
        itemInventoryList.add(new ItemInventory(1, "Samsung Galaxy S6", BigDecimal.valueOf(199.996), "Worldly looks and top-notch specs make the impressive, metal Samsung Galaxy S6 the Android phone to beat for 2015", "samsung_galaxy_s6","Mob1234","Electronics","DXL"));
        itemInventoryList.add(new ItemInventory(2, "HTC One M8", BigDecimal.valueOf(449.9947), "Excellent overall phone. Beautifull, battery life more than 20 hours daily and great customization in any way. 100% configuration on any aspect", "htc_one_m8","Mob5678","Electronics","DXL"));
        itemInventoryList.add(new ItemInventory(3, "Xiaomi Mi3", BigDecimal.valueOf(319.998140), "Xiaomi's Mi 3 is a showcase of how Chinese phonemakers can create quality hardware without breaking the bank. If you don't need 4G LTE, and you can get hold of it, this is one of the best smartphones you can buy in its price range.", "xiaomi_mi3","Mob08963","Electronics","DXL"));
        }
         else if(itemCategory.getCategoryId()==Constant.CLOTHES)
        {
            itemInventoryList.add(new ItemInventory(4, "Asia Edge Joker", BigDecimal.valueOf(199.996), "Asia Edge great Tshirts at very nominal price", "asia_edge","Clo1234","Fashion","DXL"));
            itemInventoryList.add(new ItemInventory(5, "Clifton Steel gray", BigDecimal.valueOf(449.9947), "Clifton Steel gray great Tshirts at very nominal price with great shades", "clifton","Clo5678","Fashion","DXL"));
            itemInventoryList.add(new ItemInventory(6, "Henley Full Sleeve", BigDecimal.valueOf(319.998140), "Henley Full Sleeve great Tshirts at very nominal price", "henley_full_sleeve","Clo08963","Fashion","DXL"));
        }
       else if(itemCategory.getCategoryId()==Constant.SHOES)
        {
            itemInventoryList.add(new ItemInventory(1, "Woodland Leather", BigDecimal.valueOf(199.996), "Woodland Leather with tough leather which survives for long", "woodland","Sho1234","Shoes","DXL"));
            itemInventoryList.add(new ItemInventory(2, "Lee Cooper", BigDecimal.valueOf(449.9947), "Excellent overall Lee Cooper shoes with great price", "lee_cooper","Sho5678","Shoes","DXL"));
            itemInventoryList.add(new ItemInventory(3, "Black Tiger", BigDecimal.valueOf(319.998140), "Excellent Black Tiger shoes desgined only for you", "black_tiger","Sho0123","Shoes","DXL"));
        }
       else if(itemCategory.getCategoryId()==Constant.CAMERAS)
        {
            itemInventoryList.add(new ItemInventory(7, "Nikon s9", BigDecimal.valueOf(199.996), "Nikon s9 with superb lens quality and sleak desgin", "niko_1234","Mob1234","Electronics","DXL"));
            itemInventoryList.add(new ItemInventory(8, "Nikon s2900", BigDecimal.valueOf(449.9947), "Nikon s2900 with superb lens quality and sleak desgin with great options","nikon_s2900","Mob7854","Electronics","DXL"));
            itemInventoryList.add(new ItemInventory(9, "Nikon s3700", BigDecimal.valueOf(319.998140), "Nikon s3700 with superb lens quality and sleak desgin within your reach", "nikon_s3700","A1234","Electronics","DXL"));
        }
        else if(itemCategory.getCategoryId()==Constant.Laptops)
        {
            itemInventoryList.add(new ItemInventory(10, "Lenovo ThinkPad", BigDecimal.valueOf(199.996), "Lenovo ThinkPad with exciting new features and great price", "lenovo_thinkpad","Lap1234","Electronics","DXL"));
            itemInventoryList.add(new ItemInventory(11, "HP Pavillion", BigDecimal.valueOf(449.9947), "HP Pavillion this season with great price and windows 10 inbuilt","hp_pavllion","Lap7854","Electronics","DXL"));
            itemInventoryList.add(new ItemInventory(13, "Dell Inspiron", BigDecimal.valueOf(319.998140), "Dell Inspiron is most advance dell laptop with all new prices", "dell_inspiron","Lap1234","Electronics","DXL"));
        }
            return  itemInventoryList;

    }

    public static ArrayList<ItemCategory> intialiazeCategories()
    {
        final ArrayList<ItemCategory> itemCategories = new ArrayList<ItemCategory>();
        itemCategories.add(new ItemCategory(1,"Mobiles"));
        itemCategories.add(new ItemCategory(2,"Clothes"));
        itemCategories.add(new ItemCategory(3,"Shoes"));
        itemCategories.add(new ItemCategory(4,"Cameras"));
        itemCategories.add(new ItemCategory(5,"Laptops"));
        return itemCategories;
    }
    public static List<Integer> intialiazeQuantities()
    {
        List<Integer> quantityList = new ArrayList<Integer>();
        for (int i = 1; i < 11; i++) quantityList.add(i);
        return  quantityList;
    }
}
