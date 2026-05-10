package com.srv.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonUtils {

    public static JSONObject getJsonData(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            // Đọc file từ đường dẫn truyền vào
            Object obj = parser.parse(new FileReader(filePath));
            // Ép kiểu về JSONObject để dễ dàng lấy dữ liệu theo Key
            return (JSONObject) obj;
        } catch (Exception e) {
            System.out.println("[Error] Không đọc được file JSON: " + e.getMessage());
            return null;
        }
    }
}