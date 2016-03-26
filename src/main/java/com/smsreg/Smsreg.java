package com.smsreg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sh on 3/20/2016.
 */
public class Smsreg {
    private final String url = "https://sms-reg.com/login.php";
    private final String login = "svsash";
    private final String password = "zGsnvfZzv4sp";
    private final WebDriver driver = new FirefoxDriver();


    public void load() {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[1]/div[2]/div[2]/form/p[1]/input")));

        driver.manage().window().maximize();
        driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div[2]/form/p[1]/input")).sendKeys(login);
        driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div[2]/form/p[2]/input")).sendKeys(password);
        driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div[2]/form/p[3]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stream")));
    }

    public void setServise(){
        driver.findElement(By.id("t1")).click();
        driver.findElement(By.id("opt4")).click();
    }

    public void setCountry(){
        driver.findElement(By.id("t2")).click();
        driver.findElement(By.id("r2l")).click();
    }

    public void getPhoneNumber(){
        driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[1]/span[3]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 2260);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stream")));
        System.out.println(driver.findElement(By.xpath(".//*[@id='stream']/div/span[1]")).getText());
    }
}