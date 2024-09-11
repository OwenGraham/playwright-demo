package com.sparta.playwrightdemo.pages;

import com.microsoft.playwright.Locator;

public class CartItem {
    private int quantity;
    private Locator itemLink;
    private String title;
    private String description;
    private Float price;
    private Locator removeButton;

    public CartItem(Builder builder){
        this.quantity = builder.quantity;
        this.itemLink = builder.itemLink;
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
        this.removeButton = builder.removeButton;
    }

    public int getQuantity() {
        return quantity;
    }

    public Locator getItemLink() {
        return itemLink;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public Locator getRemoveButton() {
        return removeButton;
    }

    public static class Builder{
        private int quantity;
        private Locator itemLink;
        private String title;
        private String description;
        private Float price;
        private Locator removeButton;

        public Builder setQuantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder setItemLink(Locator itemLink){
            this.itemLink = itemLink;
            return this;
        }

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }

        public Builder setDescription(String description){
            this.description = description;
            return this;
        }

        public Builder setPrice(Float price){
            this.price = price;
            return this;
        }

        public Builder setRemoveButton(Locator removeButton){
            this.removeButton = removeButton;
            return this;
        }

        public CartItem build(){
            return new CartItem(this);
        }
    }
}
