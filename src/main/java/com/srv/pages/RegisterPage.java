package com.srv.pages;

import com.srv.base.BasePage;

public class RegisterPage extends BasePage {
    // 1. Dùng private để đóng gói Locator (Encapsulation)
    private String txtEmail = "id=email";
    private String txtPhone = "id=phone";
    private String btnRegister = "xpath=//button";

    // 2. Thực hiện "Hợp đồng" từ BasePage (Abstract)
    @Override
    public void waitPageLoaded() {
        System.out.println("Đang đợi trang Register tải xong các phần tử...");
    }

    // 3. Nghiệp vụ (Action)
    public void performRegister(String email, String phone) {
        sendKeys(txtEmail, email);
        sendKeys(txtPhone, phone);
        clickElement(btnRegister);
    }
}