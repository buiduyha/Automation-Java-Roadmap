package com.srv.pages;

import com.srv.base.BasePage;

public class CartPage extends BasePage {
    private String btnCheckout = "id=checkout";
//    private String btnCheckout = "xpath=//button[@id='checkout']";
//    private String btnCheckout = "xpath=//button[@class='btn btn_action btn_medium checkout_button']";
//    private String btnCheckout = "xpath=//button[contains(@name, 'checkout')]";
//    private String btnCheckout = "xpath=//button[text()='Checkout']";

    @Override
    public void waitPageLoaded() {
    }

    public void checkout() {
        clickElement(btnCheckout);
        System.out.println("Chuyển sang bước thanh toán");
    }
}
