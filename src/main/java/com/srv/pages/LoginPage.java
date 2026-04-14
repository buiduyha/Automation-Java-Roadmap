package com.srv.pages;

import com.srv.base.BasePage;

public class LoginPage extends BasePage {
    // 1. Locator - Đóng gói kín bằng private
    private String txtUsername = "user-name";
    private String txtPassword = "password";
    private String btnLogin = "login-button";

    // 2. Thực hiện cam kết từ cha (Abstract method)
    @Override
    public void waitPageLoaded() {
        System.out.println("[POM] Đợi trang Login hiển thị hoàn tất...");
    }

    // 3. Hành động (Method) - Chỉ lộ ra nghiệp vụ cho bên ngoài dùng
    public void loginToSystem(String user, String pass) {
        System.out.println("--- Thực hiện luồng Login ---");
        sendKeys(txtUsername, user);
        sendKeys(txtPassword, pass);
        clickElement(btnLogin);
    }
}