package com.srv.tests;

import com.srv.base.BasePage;
import com.srv.pages.*; // Import tất cả các trang
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    // Khai báo sẵn các "vũ khí"
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        // 1. Cấu hình Chrome (bao gồm cả tab ẩn danh)
        ChromeOptions options = new ChromeOptions();

        // 1.1. Tắt tính năng lưu mật khẩu và kiểm tra rò rỉ mật khẩu
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // 1.2. Chặn các thanh thông báo khó chịu của Chrome
        options.addArguments("--incognito");
        options.addArguments("--disable-features=AutofillPasswordLeakDetection");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Gán driver cho BasePage dùng chung
        BasePage.setDriver(driver);

        // --- KHỞI TẠO CÁC TRANG TẠI ĐÂY ---
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterMethod
    public void tearDown() {
        BasePage.quitDriver();
    }
}