package com.srv.tests;

import com.srv.base.BasePage;
import com.srv.pages.CartPage;
import com.srv.pages.InventoryPage;
import com.srv.pages.LoginPage;
import com.srv.pages.PaymentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EndToEndTest {
    public static void main(String[] args) {
        // 1. Khởi tạo trình duyệt
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Bơm driver vào hệ thống BasePage
        BasePage.setDriver(driver);

        // 3. Bắt đầu kịch bản
        driver.get("https://www.saucedemo.com/");

        LoginPage login = new LoginPage();
        login.waitPageLoaded();
        login.loginToSystem("standard_user", "secret_sauce");
        login.waitForPageTitle("Swag Labs");

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.waitPageLoaded();
        inventoryPage.printAllProductNames();
        inventoryPage.addProductToCart();
        inventoryPage.addProductToCart();
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
        paymentPage.payment("Nguyen Van A", "100000");

        System.out.println("=== TEST TRÊN TRÌNH DUYỆT THẬT THÀNH CÔNG ===");

        BasePage.quitDriver(); // Tạm thời comment lại để bạn ngắm kết quả trên trình duyệt
    }
}
