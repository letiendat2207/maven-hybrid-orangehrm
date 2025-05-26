package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_08 {
    // non-static
    // muon dung non-static phai new qua 1 doi tuong object
    // bien address thuoc pham vi doi tuong
    String address = "43 Hoa Binh";

    // Pham vi static la chia se cho toan bo system su dung
    // Dung static ko can new qua 1 doi tuong object
    // Bien name thuoc pham vi class
    static String name = "Le Tien Dat";

    // neu nhu co static final thi day la 1 HANG SO
    // gia tri ko dc phep thay doi
    static final String AGE = "26";

    @Test
    public void TC_01() throws InterruptedException {
        // Doi tuong la topic08
        Topic_08 topic08 = new Topic_08();
        topic08.address = "325 Lanh Binh Thai";
        topic08.name = "Jason Le";

        // topic08.AGE = "14";

        String osName = "Windows 11";
        String seperator = null;
        WebDriver driver;

        // Condition Statement
        // if-else
        if (osName.contains("Windows")) {
            seperator = "\\";
        } else {
            seperator = "/";
        }

        String browserName = "Chrome";
        // switch-case
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not supported!");
        }

        // Loop Statement

        // for
        // Classic for - Iteration for
        int studentNumber = 10;
        for (int i = 0; i < studentNumber; i++) {
            System.out.println(i);
        }
        for (int i = 0; i < studentNumber; i++) {
            if (i == 5) {
                System.out.println(i);
            }
        }

        // For-Each
        List<String> stdName = new ArrayList<String>();
        for (String std : stdName) {
            System.out.println(std);
        }

        // while
        int x = 0;
        while (x < studentNumber) {
            System.out.println(x);
            x++;
        }

        // do-while
        int z = 11;
        do {
            System.out.println(z);
            z++;
        } while (z < studentNumber);

        // try-catch
        // neu nhu element ko dc tim thay thi cung ko bao loi
        try {
            // Happy case
            driver.findElement(By.cssSelector("")).isDisplayed();
        } catch (NoSuchElementException exception){
            // Edge case
            System.out.println(exception.getMessage());
        } finally {
            // Close connection: DB/ File/...
            // Neu nhu co finally thi bat buoc phai chay qua
        }

        Thread.sleep(5000);
    }
}
