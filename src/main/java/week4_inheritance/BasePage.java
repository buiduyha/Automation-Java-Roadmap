package week4_inheritance;

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

// Week 4 - Thursday - Abstract Class
// Thêm từ khóa abstract
public abstract class BasePage {

    public void clickElement(String name) {
        System.out.println("Clicking: " + name);
    }

    // Hàm trừu tượng: Không có nội dung {}, kết thúc bằng dấu ;
    // Bắt buộc mọi Class con phải tự định nghĩa logic này
    public abstract void waitPageLoaded();
}