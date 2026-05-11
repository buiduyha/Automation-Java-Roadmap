package com.srv.tests;

import org.json.simple.JSONObject;
import com.srv.utils.JsonUtils;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Test
    public void testLoginWithConfig() {
        // 1. Đọc file JSON tổng
        JSONObject root = JsonUtils.getJsonData("src/test/resources/config.json");

        // 2. Lấy biến môi trường (URL)
        JSONObject env = (JSONObject) root.get("env");
        String baseUrl = env.get("url").toString();

        // 3. Lấy dữ liệu tài khoản
        JSONObject userData = (JSONObject) root.get("user_data");
        JSONObject validUser = (JSONObject) userData.get("valid_user");

        String user = validUser.get("username").toString();
        String pass = validUser.get("password").toString();

        // 4. Sử dụng
        driver.get(baseUrl);
        loginPage.login(user, pass);
    }
}