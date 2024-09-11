package com.sparta.playwrightdemo.pages;

import com.microsoft.playwright.Locator;
import com.sparta.playwrightdemo.utils.TestContext;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private final TestContext testContext;

    public CartPage(TestContext testContext){
        this.testContext = testContext;
    }

    public List<CartItem> getItems(){
        List<CartItem> items = new ArrayList<>();
        List<Locator> elements = testContext.page.locator(".cart_item").all();
        for (Locator element : elements){
            CartItem item = new CartItem.Builder()
                    .setQuantity(Integer.parseInt(element.locator(".cart_quantity").textContent()))
                    .setItemLink(element.locator("a"))
                    .setTitle(element.locator(".inventory_item_name").textContent())
                    .setDescription(element.locator(".inventory_item_desc").textContent())
                    .setPrice(Float.valueOf(element.locator(".inventory_item_price").textContent().substring(1)))
                    .setRemoveButton(element.locator(".cart_button"))
                    .build();

            items.add(item);
        }
        return items;
    }

    public Boolean hasItem(String title){
        Boolean found = false;
        for (CartItem item : getItems()){
            if (item.getTitle().equals(title)){
                found = true;
                break;
            }
        }
        return found;
    }
}
