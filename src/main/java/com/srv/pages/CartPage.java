package com.srv.pages;

import com.srv.base.BasePage;

public class CartPage extends BasePage {
    private String lblProductName = "xpath=//div[@class='inventory_item_name']";
    private String btnCheckout = "id=checkout";

    @Override
    public void waitPageLoaded() {
        System.out.println("Đang kiểm tra giỏ hàng...");
    }

    // Hàm lấy tên sản phẩm để Assert (Kiểm tra)
    public String getProductNameInCart() {
        return getElementText(lblProductName);
    }

    public void clickCheckout() {
        clickElement(btnCheckout);
    }
}