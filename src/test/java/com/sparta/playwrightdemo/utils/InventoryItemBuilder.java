package com.sparta.playwrightdemo.utils;

import com.microsoft.playwright.Locator;
import com.sparta.playwrightdemo.pages.InventoryItem;

public class InventoryItemBuilder {
    public String title;
    public String description;
    public float price;
    public String imgURL;
    public Locator addToCartButton;
    public Locator itemLink;

    public InventoryItemBuilder setTitle(String title){
        this.title = title;
        return this;
    }

    public InventoryItemBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public InventoryItemBuilder setPrice(float price){
        this.price = price;
        return this;
    }

    public InventoryItemBuilder setImgURL(String imgURL){
        this.imgURL = imgURL;
        return this;
    }

    public InventoryItemBuilder setAddToCartButton(Locator addToCartButton){
        this.addToCartButton = addToCartButton;
        return this;
    }

    public InventoryItemBuilder setItemLink(Locator itemLink){
        this.itemLink = itemLink;
        return this;
    }

    public InventoryItem build(){
        InventoryItem item = new InventoryItem();
        item.setTitle(title);
        item.setDescription(description);
        item.setPrice(price);
        item.setImgURL(imgURL);
        item.setAddToCartButton(addToCartButton);
        item.setItemLink(itemLink);

        return item;
    }
}
