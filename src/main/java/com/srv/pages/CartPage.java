package com.srv.pages;

import com.srv.base.BasePage;

public class CartPage extends BasePage {
    private String btnCheckout = "id=checkout-button";

    @Override
    public void waitPageLoaded() {
    }

    public void checkout() {
        clickElement(btnCheckout);
        System.out.println("Chuyển sang bước thanh toán");
    }
}
