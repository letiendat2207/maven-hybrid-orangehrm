package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Topic_06 {
    // This class is abstract class, it will have non-abstract and abstract method
    // no initialization allowed - khong cho khoi tao
    // only inheritance allowed - chi cho ke thua

    // OOP: Abstraction - tinh chat truu tuong

    // Lay du lieu ra (khac void)
    public String getFullName() {
        WebDriver driver = new FirefoxDriver();
        driver.getTitle();      // ham tra ve String

        return null;    // dung return de tra ve kieu du lieu cho ham get khac void
    }

    // Action Method, dung void
    public void setFullName() {
        // ham void khong dung tu khoa return

        WebDriver driver = new FirefoxDriver();
        driver.close();     // ham tra ve kieu void, la ham action
    }
}
