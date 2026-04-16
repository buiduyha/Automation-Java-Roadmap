package com.srv.tests;

import com.srv.base.BasePage;
import com.srv.pages.CartPage;
import com.srv.pages.InventoryPage;
import com.srv.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.waitPageLoaded();
        inventoryPage.count();
        inventoryPage.printAllProductNames();
//        inventoryPage.addProductToCart();
//        inventoryPage.checkout();
//
//        CartPage cartPage = new CartPage();
//        cartPage.waitPageLoaded();
//        System.out.println("Sản phẩm trong giỏ là: " + cartPage.getProductNameInCart());
//        cartPage.clickCheckout();

        System.out.println("=== TEST TRÊN TRÌNH DUYỆT THẬT THÀNH CÔNG ===");

//        driver.quit(); // Tạm thời comment lại để bạn ngắm kết quả trên trình duyệt
    }
}
