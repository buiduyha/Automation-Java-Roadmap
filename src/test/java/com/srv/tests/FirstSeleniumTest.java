package com.srv.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
    public static void main(String[] args) {
        // 1. Khởi tạo trình duyệt Chrome
        WebDriver driver = new ChromeDriver();

        // 2. Phóng to cửa sổ
        driver.manage().window().maximize();

        // 3. Truy cập vào 1 trang web
        driver.get("https://www.saucedemo.com/");

        // 4. Lấy tiêu đề trang và in ra để kiểm tra
        System.out.println("Tiêu đề trang là " + driver.getTitle());

        // 5. Đóng trình duyệt
        driver.quit();
    }
}
