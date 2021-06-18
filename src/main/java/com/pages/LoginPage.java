package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private By emailID = By.xpath("//input[@data-test='username']");
    private By password = By.xpath("//input[@data-test='password']");
    private By loginButton = By.xpath("//input[@type='submit']");
    private By header = By.xpath("//div[@id='login_credentials']/h4");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailID() {
        return getElement(emailID);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    public WebElement getHeader() {
        return getElement(header);
    }

    public String getLoginPageTitle(){
        return getPageTitle();
    }

    public String getLoginPageHeader(){
        return getPageHeader(header);
    }

    public HomePage doLogin(String userName, String pass){
        getEmailID().sendKeys(userName);
        getPassword().sendKeys(pass);
        getLoginButton().click();
        return getPageInstance(HomePage.class);
    }

    public void doLogin(){
        getEmailID().sendKeys("");
        getPassword().sendKeys("");
        getLoginButton().click();
    }






}
