package com.srv.pages;

import com.srv.base.BasePage;

public class InventoryPage extends BasePage {
    private String btnAddToCart = "id=add-to-cart-sauce-labs-backpack";

    @Override
    public void waitPageLoaded() {
        System.out.println("Đang đợi trang Danh sách sản phẩm hiển thị...");
    }

    public void addProductToCart() {
        clickElement(btnAddToCart);
        System.out.println("Đã thêm sản phẩm vào giỏ hàng thành công!");
    }
}
