package com.srv.tests;

import com.srv.base.BasePage;
import com.srv.pages.CartPage;
import com.srv.pages.InventoryPage;
import com.srv.pages.LoginPage;
import com.srv.pages.PaymentPage;
import com.srv.utils.JsonUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class EndToEndTest {
    public static void main(String[] args) {
        // 1. Khởi tạo trình duyệt
        ChromeOptions options = new ChromeOptions();

        // 1. Tắt tính năng lưu mật khẩu và kiểm tra rò rỉ mật khẩu
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // 2. Chặn các thanh thông báo khó chịu của Chrome
        options.addArguments("--incognito");
        options.addArguments("--disable-features=AutofillPasswordLeakDetection");
        options.addArguments("--disable-notifications");

        // Khởi tạo driver với options đã cấu hình
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // 2. Bơm driver vào hệ thống BasePage
        BasePage.setDriver(driver);

        // 3. Bắt đầu kịch bản
        driver.get("https://www.saucedemo.com/");

        testLoginWithJson();

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.waitPageLoaded();
        inventoryPage.printAllProductNames();
        inventoryPage.addProductToCart();
        inventoryPage.addProductToCart();
        inventoryPage.hoverShoppingCart();
        inventoryPage.checkout();

        CartPage cartPage = new CartPage();
        cartPage.waitPageLoaded();
        String actualProductName = cartPage.getProductNameInCart().get(0).getText();
        String expectedProductName = "Sauce Labs Backpack";
        Assert.assertEquals(actualProductName, expectedProductName, "LỖI: Tên sản phẩm trong giỏ không khớp!");
        actualProductName = cartPage.getProductNameInCart().get(1).getText();
        expectedProductName = "Sauce Labs Bike Light";
        Assert.assertEquals(actualProductName, expectedProductName, "LỖI: Tên sản phẩm trong giỏ không khớp!");
        cartPage.clickCheckout();

        PaymentPage paymentPage = new PaymentPage();
        paymentPage.waitPageLoaded();
        paymentPage.payment("A","Nguyen Van A", "100000");

        System.out.println("=== TEST TRÊN TRÌNH DUYỆT THẬT THÀNH CÔNG ===");

        BasePage.quitDriver(); // Tạm thời comment lại để bạn ngắm kết quả trên trình duyệt
    }

    @org.testng.annotations.Test
    public static void testLoginWithJson() {
        // 1. Lấy dữ liệu từ file JSON
        String path = "src/test/resources/account.json";
        JSONObject data = JsonUtils.getJsonData(path);

        // 2. Trích xuất giá trị theo Key
        String user = (String) data.get("username");
        String pass = (String) data.get("password");

        // 3. Thực hiện các bước Test
        LoginPage login = new LoginPage();
        login.loginToSystem(user, pass);

        System.out.println("Đã đăng nhập với tài khoản: " + user);
    }
}
