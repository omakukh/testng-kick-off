package com.lits.makukh.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public  void google_search_test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://yahoo.com");
        WebElement searchTextBox = driver.findElement(By.id("header-search-input"));
        searchTextBox.sendKeys("Tesla Motors");
        searchTextBox.submit();
       // driver.findElement(By.name("btnK")).click();
        Thread.sleep(3000);
        driver.quit();


    }

}
