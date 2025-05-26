package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

// class ke thua class dung extends
// class ke thua interface dung implements
public class Topic_01_Keywords extends Topic_06 implements Topic_02 {
    // This class is normal class, it will have non-abstract method
    // Don't have abstract method
    // Allow to initialize - khoi tao binh thuong
    // Inheritance allowed - cho phep ke thua

    // Data Type
    char c = 'A';
    byte bNumber = 10;
    short sNumber = 100;
    int iNumber = 1500;
    long lNumber = 2344321;
    float fNumber = 3.14F;
    double dNumber = 19.37216381D;
    boolean marialStatus = false;
    String fullName = null;

    // Access Modifier

    // Variable
    private String studentName = "Le Tien Dat";
    String studentAddress = "325 Ngo Quyen";
    protected int studentAge = 26;
    public double studentPoint = 9.5;

    // Method
    // Chi co ham (method) moi co void, khi ham ko co kieu du lieu tra ve thi dung void
    private void TC_01() {
        WebDriver driver = new FirefoxDriver();

        Topic_01_Keywords topic01 = new Topic_01_Keywords();
    }

    void TC_02() {

    }

    protected void TC_03() {

    }

    public void TC_04() {

    }

    @Override
    public void clearStudent() {

    }

    // Class - Interface - Enum - Record - Annotation all used Public
}
