package com.srv.tests;

import com.srv.pages.CartPage;
import com.srv.pages.InventoryPage;
import com.srv.pages.LoginPage;
import com.srv.pages.PaymentPage;

public class EndToEndTest {
    public static void main(String[] args) {
        // 1. Setup trình duyệt
        System.out.println("=== KHỞI TẠO HỆ THỐNG ===");

        // 2. Thực hiện Login
        LoginPage login = new LoginPage();
        login.waitPageLoaded();
        login.loginToSystem("standard_user", "secret_sauce");

        // 3. Chọn hàng
        InventoryPage inventory = new InventoryPage();
        inventory.waitPageLoaded();
        inventory.addProductToCart();

        // 4. Checkout
        CartPage cartPage = new CartPage();
        cartPage.waitPageLoaded();
        cartPage.checkout();

        // 5. Thanh toán
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.waitPageLoaded();
        paymentPage.payment("Nguyen Van A", "00000");

        // 6. Kết thúc
        System.out.println("=== TEST CASE PASSED ===");
    }
}
