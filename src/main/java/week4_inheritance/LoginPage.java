package week4_inheritance;

// LoginPage "LÀ MỘT" Page (Inheritance)
public class LoginPage extends BasePage {

    public void login(String user, String pass) {
        waitForPageLoaded(); // Hàm của cha
        sendKeys("Username Field", user); // Hàm của cha
        sendKeys("Password Field", pass); // Hàm của cha
        clickElement("Login Button"); // Hàm của cha
        System.out.println("Đăng nhập thành công!");
    }
}