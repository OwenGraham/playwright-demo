package com.sparta.playwrightdemo.steps;

import com.sparta.playwrightdemo.pages.LoginPage;
import com.sparta.playwrightdemo.pages.WebPage;
import com.sparta.playwrightdemo.utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefs {
    private final TestContext context;
    private final LoginPage loginPage;

    public LoginStepDefs(TestContext context) {
        this.context = context;
        this.loginPage = new LoginPage(context);
    }

    @When("the user enters the username {string} and the password {string}")
    public void theUserEntersTheUsernameAndThePassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.login();
    }

    @Then("the user should be redirected to the home page")
    public void theUserShouldBeRedirectedToTheHomePage() {
        Assertions.assertEquals(WebPage.valueOf("INVENTORY").getURL(),context.page.url());
    }

    @Then("the user should see an error message indicating incorrect credentials")
    public void theUserShouldSeeAnErrorMessageIndicatingIncorrectCredentials() {
        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertTrue(errorMessage.contains("Epic sadface"));
    }

    @When("the user leaves the username field empty and enters the password {string}")
    public void theUserLeavesTheUsernameFieldEmptyAndEntersThePassword(String password) {
        loginPage.enterUsername("");
        loginPage.enterPassword(password);
    }

    @Then("the user should see an error message indicating that the username is required")
    public void theUserShouldSeeAnErrorMessageIndicatingThatTheUsernameIsRequired() {
        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertTrue(errorMessage.contains("Username is required"));
    }

    @When("the user enters the username {string} and leaves the password field empty")
    public void theUserEntersTheUsernameAndLeavesThePasswordFieldEmpty(String username) {
        loginPage.enterUsername(username);
        loginPage.enterPassword("");
    }

    @Then("the user should see an error message indicating that the password is required")
    public void theUserShouldSeeAnErrorMessageIndicatingThatThePasswordIsRequired() {
        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertTrue(errorMessage.contains("Password is required"));
    }

    @Then("the user should see an error message indicating that the account is locked")
    public void theUserShouldSeeAnErrorMessageIndicatingThatTheAccountIsLocked() {
        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertTrue(errorMessage.contains("Sorry, this user has been locked out"));
    }
}
