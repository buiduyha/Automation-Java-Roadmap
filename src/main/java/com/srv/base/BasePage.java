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
import java.util.ArrayList;
import java.util.List;

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

    // Hàm bổ trợ để chuyển đổi String Locator thành đối tượng By của Selenium
    private By getBy(String locator) {
        if (locator.startsWith("id=")) {
            return By.id(locator.replace("id=", ""));
        } else if (locator.startsWith("name=")) {
            return By.name(locator.replace("name=", ""));
        } else if (locator.startsWith("css=")) {
            return By.cssSelector(locator.replace("css=", ""));
        } else if (locator.startsWith("xpath=")) {
            return By.xpath(locator.replace("xpath=", ""));
        } else {
            return By.id(locator); // Mặc định là ID nếu không ghi gì
        }
    }

    // Cập nhật lại các hàm click và sendKeys
    public void clickElement(String locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getBy(locator)));
        System.out.println("[Selenium] Clicking: " + locator);
        element.click();
    }

    public void sendKeys(String locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getBy(locator)));
        System.out.println("[Selenium] Typing '" + value + "' into: " + locator);
        element.clear();
        element.sendKeys(value);
    }

    public String getElementText(String locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getBy(locator)));
        return element.getText();
    }

    // Lấy danh sách các WebElements
    public List<WebElement> getWebElements(String locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getBy(locator)));
    }

    // Lấy danh sách Text của tất cả phần tử (Ví dụ: Lấy tên tất cả sản phẩm)
    public List<String> getAllElementText(String locator) {
        List<WebElement> elements = getWebElements(locator);
        List<String> texts = new ArrayList<>();
        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts;
    }

    public void waitForElementInvisible(String locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(getBy(locator)));
        System.out.println("[Wait] Loading spinner has disappeared!");
    }

    public void waitForPageTitle(String title) {
        // Đợi cho đến khi tiêu đề chứa đoạn text mong muốn
        wait.until(ExpectedConditions.titleContains(title));
        System.out.println("[Wait] Page title is now: " + driver.getTitle());
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("[Selenium] Browser closed.");
        }
    }

    // Hàm trừu tượng: Không có nội dung {}, kết thúc bằng dấu ;
    // Bắt buộc mọi Class con phải tự định nghĩa logic này
    public abstract void waitPageLoaded();
}