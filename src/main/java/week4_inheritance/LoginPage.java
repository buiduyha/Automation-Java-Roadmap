package week4_inheritance;

// LoginPage "LÀ MỘT" Page (Inheritance)
public class LoginPage extends BasePage {

    // Week 4 - Monday: Implement Inheritance with BasePage
//    public void login(String user, String pass) {
//        waitForPageLoaded(); // Hàm của cha
//        sendKeys("Username Field", user); // Hàm của cha
//        sendKeys("Password Field", pass); // Hàm của cha
//        clickElement("Login Button"); // Hàm của cha
//        System.out.println("Đăng nhập thành công!");
//    }

    // Week 4 - Tuesday: Override
    // Ghi đè lại hàm clickElement của BasePage
    @Override
    public void clickElement(String elementName) {
        System.out.println("[Security Check] Đang kiểm tra mã độc trước khi click...");
        // Gọi lại hàm gốc của Cha nếu vẫn muốn dùng logic cũ
        super.clickElement(elementName);
        System.out.println("[Log] Click thành công nút bảo mật.");
    }

    public void login(String user, String pass) {
        waitForPageLoaded();
        sendKeys("Username Field", user);
        sendKeys("Password Field", pass);
        clickElement("Login Button"); // Lúc này nó sẽ gọi hàm đã được Overwrite ở trên
    }
}