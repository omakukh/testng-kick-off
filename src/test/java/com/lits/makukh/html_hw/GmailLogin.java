package com.lits.makukh.html_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailLogin {

    private static WebDriver driver;

    @BeforeClass
    public void initDriver() {

        String baseUrl = "https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/";

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
    public void signInTest() throws InterruptedException {

        driver.findElement(By.id("identifierId")).sendKeys("testlits9@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("Test12345!");
        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Inbox']")).isDisplayed());
    }
}