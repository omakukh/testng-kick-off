package com.lits.makukh.html_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Coins {

    private String trueRandomNumberService = "True Random Number Service";
    private String coinFlipper = "Coin Flipper";
    private static WebDriver driver;

    @BeforeClass
    public void initDriver() {

        String baseUrl = "https://www.random.org/coins/";

        System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }


    @Test
    public void checkElementPresenceTest() {


        WebElement spanElement = driver.findElement(By.tagName("span"));
        Assert.assertNotNull(spanElement);
        Assert.assertTrue(spanElement.isDisplayed());
        Assert.assertEquals(spanElement.getText(), trueRandomNumberService);

        WebElement h2Element = driver.findElement(By.tagName("h2"));
        Assert.assertNotNull(h2Element);
        Assert.assertTrue(h2Element.isDisplayed());
        Assert.assertEquals(h2Element.getText(), coinFlipper);
    }

    @Test
    public void flipCoinsTest() {
        double[] coins1 = flipCoins("200", "40-antique.maximinus");
        Assert.assertTrue(Math.abs(coins1[0] - coins1[1]) < 10);

        driver.findElement(By.xpath("//input[@value='Go Back']")).click();
        driver.findElement(By.xpath("//input[@value='Reset Form']")).click();

        double[] coins2 = flipCoins("180", "20-novelty.decision-maker");
        Assert.assertTrue(Math.abs(coins2[0] - coins2[1]) < 10);
    }

    private double[] flipCoins(String coinNum, String coinType) {

        Select dropDownFlip = new Select(driver.findElement(By.name("num")));
        dropDownFlip.selectByValue(coinNum);

        Select dropDownCoinType = new Select(driver.findElement(By.name("cur")));
        dropDownCoinType.selectByValue(coinType);

        driver.findElement(By.xpath("//input[@value='Flip Coin(s)']")).click();

        int obverseCount = driver.findElements(By.xpath("//img[@title='obverse']")).size();
        int reverseCount = driver.findElements(By.xpath("//img[@title='reverse']")).size();
        System.out.println("Amount of obverse coins: " + obverseCount);
        System.out.println("Amount of reverse coins: " + reverseCount);


        return new double[]{(obverseCount / Double.valueOf(coinNum)) * 100, (reverseCount / Double.valueOf(coinNum)) * 100};
    }

}
