package com.sparta.playwrightdemo.pages;

import com.sparta.playwrightdemo.utils.TestContext;

public class LoginPage {
    private final TestContext context;

    public LoginPage(TestContext context) {
        this.context = context;
    }

    public void enterUsername(String username){
        context.page.fill("#user-name",username);
    }

    public void enterPassword(String password){
        context.page.fill("#password",password);
    }

    public void login(){
        context.page.click("#login-button");
    }

    public String getErrorMessage(){
        return context.page.locator("text=Epic sadface").textContent();
    }
}
