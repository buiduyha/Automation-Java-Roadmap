package com.srv.pages;

import com.srv.base.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {
    //    private String btnAddToCart = "id=add-to-cart-sauce-labs-backpack";
    private String btnAddToCart = "xpath=//button[contains(., 'Add to cart')]";
    private String itemBackpack = "xpath=//div[text()='Sauce Labs Backpack']";
    private String iconShoppingCart = "xpath=//a[@class='shopping_cart_link']";
    private String allProductNames = "css=.inventory_item_name";

    @Override
    public void waitPageLoaded() {
        System.out.println("Đang đợi trang Danh sách sản phẩm hiển thị...");
    }

    public void addProductToCart() {
        clickElement(btnAddToCart);
        System.out.println("Đã thêm sản phẩm vào giỏ hàng thành công!");
    }

    public void checkout() {
        clickElement(iconShoppingCart);
        System.out.println("Chuyển sang màn giỏ hàng");
    }

    public void printAllProductNames() {
        List<String> names = getAllElementText(allProductNames);
        System.out.println("Danh sách sản phẩm trên web:");
        names.forEach(name -> System.out.println("- " + name));
    }

    public Integer count() {
        List<WebElement> webElements = getWebElements(btnAddToCart);
        System.out.println("Số nút Add to cart là " + webElements.size());
        return webElements.size();
    }
}
