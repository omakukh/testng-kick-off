package com.lits.makukh.html_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LibraryLogin {

    private static WebDriver driver;

    @BeforeClass
    public void initDriver() {

        String baseUrl = "https://sites.google.com/view/library-automation-lits/home";

        System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void libraryLoginTest() throws InterruptedException {
        driver.findElement(By.xpath("//div[@data-tooltip='Login']")).click();
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        driver.findElement(By.id("email")).sendKeys("test.lnk.mail@gmail.com");
        driver.findElement(By.id("password")).sendKeys("test123");
        driver.findElement(By.id("btn-login")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='https://pixy.org/src/449/4497838.png']")).isDisplayed());


    }

}
