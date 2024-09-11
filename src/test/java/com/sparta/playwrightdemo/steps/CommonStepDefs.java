package com.sparta.playwrightdemo.steps;

import com.microsoft.playwright.options.Cookie;
import com.sparta.playwrightdemo.pages.WebPage;
import com.sparta.playwrightdemo.utils.TestContext;
import io.cucumber.java.en.Given;

import java.util.Collections;

public class CommonStepDefs {
    private final TestContext testContext;

    public CommonStepDefs(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("the user is on the {string} page")
    public void theUserIsOnThePage(String page) {
        WebPage webPage = WebPage.valueOf(page);
        testContext.page.navigate(webPage.getURL());
    }

    @Given("the user is logged in as {string}")
    public void theUserIsLoggedInAs(String username) {
        Cookie cookie = new Cookie("session-username",username).setUrl("https://www.saucedemo.com/inventory.html");
        testContext.context.addCookies(Collections.singletonList(cookie));
    }
}
