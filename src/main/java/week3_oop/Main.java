package week3_oop;

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

// Cách sử dụng (Trong hàm week3_oop.Main)
public class Main {

//    Week 3 - Monday: Class & Object
//    public static void main(String[] args) {
//        // Tạo "Thực thể" (Object)
//        AutomationTest loginTest = new AutomationTest();
//        loginTest.testName = "Kiểm thử đăng nhập";
//
//        loginTest.runTest();
//        loginTest.showResult();
//    }

// Week 3 - Tuesday: Add Attributes and Methods to LoginAction
//    public static void main(String[] args) {
//        // Khởi tạo đối tượng
//        LoginAction login = new LoginAction();
//
//        // Gọi hành động
//        login.navigateToPage();
//
//        // Truyền dữ liệu thật vào hàm
//        login.performLogin("admin_user", "Admin@123");
//
//        // Lấy dữ liệu từ hàm trả về
//        String currentTitle = login.getTitle();
//        System.out.println("Tiêu đề trang hiện tại: " + currentTitle);
//    }

   // Week 3 - Wednesday: Constructor
   public static void main(String[] args) {
       // Vừa tạo ra là đã có URL bên trong
       LoginAction loginStaging = new LoginAction("https://staging.example.com");
       loginStaging.navigate();

       LoginAction loginProduction = new LoginAction("https://example.com");
       loginProduction.navigate();
   }

}