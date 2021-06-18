package com.tests;

import com.pages.HomePage;
import com.pages.LoginPage;
import org.jsoup.Connection;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyLoginPageTitle(){
        String title = page.getPageInstance(LoginPage.class).getLoginPageTitle();
        Assert.assertEquals(title,"Swag Labs");
    }
    //Don't have an account?
    @Test(priority = 2)
    public void verifyLoginPageHeader(){
        String header = page.getPageInstance(LoginPage.class).getLoginPageHeader();
        Assert.assertEquals(header,"Accepted usernames are:");
    }

    @Test(priority = 3)
    public void verifyLoginPage(){
        HomePage homePage = page.getPageInstance(LoginPage.class).doLogin("standard_user", "secret_sauce");
        Assert.assertEquals(homePage.getHomePageHeader(), "PRODUCTS");

        }
}
