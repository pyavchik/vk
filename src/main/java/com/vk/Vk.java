package com.vk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by sh on 3/19/2016.
 */
public class Vk {
    private String url;
    private String login;
    private String password;
    WebDriver driver = new FirefoxDriver();

    public Vk(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public void load() {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.id("quick_email")).sendKeys(login);
        driver.findElement(By.id("quick_pass")).sendKeys(password);
        driver.findElement(By.id("quick_login_button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_link")));
    }

    public void openGroup(){
        driver.get("http://vk.com/kurs_od");
    }

    public void lastPostLike(){
        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.wall_post_text")));
        driver.findElement(By.cssSelector("div.wall_post_text")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.clear_fix.flat_button")));

        driver.findElement(By.cssSelector("button.clear_fix.flat_button")).click();
    }

    public void lastPostRepost() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Поделиться")));
        driver.findElement(By.linkText("Поделиться")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("like_share_send")));
        driver.findElement(By.id("like_share_send")).click();
    }

    public void becomeUserOfGroup() {
        driver.get("http://vk.com/kurs_od");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("group_like_module")));
        driver.findElement(By.id("group_like_module")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("group_actions_btn")));

    }

    public void tearDown(){
        driver.quit();
    }

}
