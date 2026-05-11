package com.srv.pages;

import com.srv.base.BasePage;

public class CheckoutPage extends BasePage {
    private String txtFirstName = "id=first-name";
    private String txtLastName = "id=last-name";
    private String txtZipCode = "id=postal-code";
    private String btnConfirm = "id=continue";

    @Override
    public void waitPageLoaded() {
        System.out.println("Đang đợi trang thanh toán");
    }

    public void payment(String firstName, String lastName, String zipCode) {
        sendKeys(txtFirstName, firstName);
        sendKeys(txtLastName, lastName);
        sendKeys(txtZipCode, zipCode);
        clickElement(btnConfirm);
        System.out.println("Xác nhận thanh toán");
    }
}
