// Đây là "Bản thiết kế" (Class)
class AutomationTest {
    String testName;
    String status = "Not Run";

    // Phương thức (Method) - Hành động của Test Case
    void runTest() {
        System.out.println("Đang thực thi: " + testName);
        status = "Passed";
    }

    void showResult() {
        System.out.println("Kết quả test [" + testName + "]: " + status);
    }
}

// Cách sử dụng (Trong hàm Main)
public class Main {
    public static void main(String[] args) {
        // Tạo "Thực thể" (Object)
        AutomationTest loginTest = new AutomationTest();
        loginTest.testName = "Kiểm thử đăng nhập";

        loginTest.runTest();
        loginTest.showResult();
    }
}