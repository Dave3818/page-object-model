package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import com.pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    WebDriver driver;
    public Page page;

    @BeforeMethod
    @Parameters(value ={"browser"})
    public void setUp(String browser){
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equals("ff")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get("https://www.saucedemo.com/");
        try{
            Thread.sleep(5000);
         }catch(InterruptedException e){
            e.printStackTrace();
        }
        page = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown(){driver.quit();}

}
