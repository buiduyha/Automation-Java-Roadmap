package week4_inheritance;

public class RegisterPage extends BasePage {
    public void register(String email, String phone) {
        sendKeys("Email Field", email); // Hàm của cha
        sendKeys("Phone Field", phone); // Hàm của cha
        clickElement("Register Button"); // Hàm của cha
    }
}
