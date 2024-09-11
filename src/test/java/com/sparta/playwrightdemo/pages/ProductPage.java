package com.sparta.playwrightdemo.pages;

import com.microsoft.playwright.Locator;
import com.sparta.playwrightdemo.utils.TestContext;

public class ProductPage {
    private final TestContext testContext;

    public ProductPage(TestContext testContext) {
        this.testContext = testContext;
    }

    public String getTitle(){
        return testContext.page.locator(".inventory_details_name").textContent();
    }

    public String getDescription(){
        return testContext.page.locator(".inventory_details_desc").textContent();
    }

    public Float getPrice(){
        return Float.valueOf(testContext.page.locator(".inventory_details_price").textContent().substring(1));
    }

    public Locator getAddToCartButton(){
        return testContext.page.locator(".btn_inventory");
    }
}
