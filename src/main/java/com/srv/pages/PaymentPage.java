package com.srv.pages;

import com.srv.base.BasePage;

public class PaymentPage extends BasePage {
    private String txtName = "id=txt-name";
    private String txtZipCode = "id=txt-zipcode";
    private String btnConfirm = "id=btn-confirm";

    @Override
    public void waitPageLoaded() {
        System.out.println("Đang đợi trang thanh toán");
    }

    public void payment(String name, String zipCode) {
        sendKeys(txtName, name);
        sendKeys(txtZipCode, zipCode);
        clickElement(btnConfirm);
        System.out.println("Xác nhận thanh toán");
    }
}
