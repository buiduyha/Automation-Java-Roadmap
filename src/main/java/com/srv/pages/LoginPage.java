package com.srv.pages;

import com.srv.base.BasePage;

public class LoginPage extends BasePage {
    // 1. Dùng private để đóng gói Locator (Encapsulation)
    private String txtUsername = "id=user";
    private String txtPassword = "id=pass";
    private String btnLogin = "xpath=//button";

    // 2. Thực hiện "Hợp đồng" từ BasePage (Abstract)
    @Override
    public void waitPageLoaded() {
        System.out.println("Đang đợi trang Login tải xong các phần tử...");
    }

    // 3. Nghiệp vụ (Action)
    public void performLogin(String user, String pass) {
        sendKeys(txtUsername, user);
        sendKeys(txtPassword, pass);
        clickElement(btnLogin);
    }
}