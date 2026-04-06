package week4_inheritance;

public class BasePage {
    // Thuộc tính chung
    public String browser = "Chrome";

    // Phương thức chung - Viết 1 lần, dùng cho tất cả các trang
    public void clickElement(String elementName) {
        System.out.println("Clicking on element: " + elementName);
    }

    public void sendKeys(String elementName, String value) {
        System.out.println("Entering '" + value + "' into: " + elementName);
    }

    public void waitForPageLoaded() {
        System.out.println("Waiting for page to load fully...");
    }
}