package week4_inheritance;

public class RegisterPage extends BasePage {
    public void register(String email, String phone) {
//        waitForPageLoaded();
//        sendKeys("Email Field", email); // Hàm của cha
//        sendKeys("Phone Field", phone); // Hàm của cha
        clickElement("Register Button"); // Hàm của cha
    }

//    @Override
//    public void waitForPageLoaded() {
//        System.out.println("Đang đợi trang Register tải dữ liệu từ Server VinFast...");
//        super.waitForPageLoaded();
//    }

    @Override
    public void waitPageLoaded() {
        System.out.println("Register page is loaded");
    }
}
