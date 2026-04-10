package com.srv.tests;

import com.srv.pages.LoginPage;

public class LoginTest {
    public static void main(String[] args) {
        // 1. Khởi tạo trang
        LoginPage loginPage = new LoginPage();

        // 2. Chạy kịch bản
        loginPage.waitPageLoaded();
        loginPage.performLogin("admin_vinfast", "Pass12345");

        // 3. Kiểm tra kết quả (Sau này sẽ dùng TestNG/JUnit Assert)
        System.out.println("ASSERT: Kiểm tra xem Dashboard đã hiển thị chưa...");
    }
}