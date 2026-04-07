package week4_inheritance;

public class Main {
    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.login("admin", "123456");
        System.out.println("Đang chạy trên trình duyệt: " + loginPage.browser);

        RegisterPage registerPage = new RegisterPage();
        registerPage.register("abc@email.com", "0123456789");
        System.out.println("Đang chạy trên trình duyệt: " + loginPage.browser);
    }
}
