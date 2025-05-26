package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_09 {
    String name;

    // Constructor
    // Ham khoi tao
    public Topic_09(String name) {
        this.name = name;
    }

    // Khi chay da luong va goi den ham nay
    // Phai chay theo thu tu - lap trinh da luong synchronized
    public synchronized WebDriver getDriver() {
        WebDriver driver = null;

        // instanceof dung de kiem ra bien variable thuoc kieu du lieu data type gi
        if (driver instanceof FirefoxDriver) {
            // Action
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
