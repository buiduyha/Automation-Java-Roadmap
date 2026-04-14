package com.srv.base;

//public class BasePage {
//    // Thuộc tính chung
//    public String browser = "Chrome";
//
//    // Phương thức chung - Viết 1 lần, dùng cho tất cả các trang
//    public void clickElement(String elementName) {
//        System.out.println("Clicking on element: " + elementName);
//    }
//
//    public void sendKeys(String elementName, String value) {
//        System.out.println("Entering '" + value + "' into: " + elementName);
//    }
//
//    public void waitForPageLoaded() {
//        System.out.println("Waiting for page to load fully...");
//    }
//}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Week 4 - Thursday - Abstract Class
// Thêm từ khóa abstract
public abstract class BasePage {
    // Biến static để tất cả các Page con dùng chung 1 trình duyệt
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    // Hàm thiết lập driver (Sẽ gọi từ Test)
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Thay thế hàm giả lập bằng Selenium thật
    public void clickElement(String locator) {
        System.out.println("[Selenium] Clicking: " + locator);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(locator.replace("id=", ""))));
        element.click();
    }

    public void sendKeys(String locator, String value) {
        System.out.println("[Selenium] Typing '" + value + "' into: " + locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator.replace("id=",""))));
        element.clear();
        element.sendKeys(value);
    }

    // Hàm trừu tượng: Không có nội dung {}, kết thúc bằng dấu ;
    // Bắt buộc mọi Class con phải tự định nghĩa logic này
    public abstract void waitPageLoaded();
}