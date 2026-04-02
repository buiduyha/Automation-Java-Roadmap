package week3_oop;

public class LoginAction {
    // 1. Attributes (Thuộc tính)
    String url = "https://example.com/login";
    String pageTitle = "Login Page";

    // 2. Methods (Phương thức) - Hành động không trả về giá trị (void)
    void navigateToPage() {
        System.out.println("Đang mở trinh duyệt tại" + url);
    }

    // Method có tham số truyền vào (Parameter)
    void performLogin(String username, String password) {
        System.out.println("Nhập username: " + username);
        System.out.println("Nhập password: " + password);
        System.out.println("Nhấn nút Đăng nhập...");
    }

    // Method trả về giá trị (String)
    String getTitle() {
        return pageTitle;
    }

    // Method trả về lỗi sai mật khẩu
    public String getErrorMessage() {
        // Trong thực tế, chỗ này sẽ là code Selenium để lấy text từ màn hình
        String error = "Tên tài khoản hoặc mật khẩu không đúng.";
        return error;
    }
}
