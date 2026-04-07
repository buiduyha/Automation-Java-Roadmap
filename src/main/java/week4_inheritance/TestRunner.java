package week4_inheritance;

public class TestRunner {
    public static void main(String[] args) {
//        // 1. Đa hình: Biến là Cha (BasePage), nhưng thực thể là Con (LoginPage)
//        BasePage page1 = new LoginPage();
//
//        // 2. Đa hình: Biến là Cha (BasePage), nhưng thực thể là Con (RegisterPage)
//        BasePage page2 = new RegisterPage();
//
//        System.out.println("--- Chạy bài Test 1 ---");
//        page1.waitForPageLoaded();// Nó sẽ tự biết gọi hàm Override của LoginPage
//
//        System.out.println("\n--- Chạy bài Test 2 ---");
//        page2.waitForPageLoaded(); // Nó sẽ tự biết gọi hàm Override của RegisterPage

        System.out.println("\n--- Chạy bài Test 1 ---");
        runTest(new LoginPage());
        System.out.println();

        System.out.println("\n--- Chạy bài Test 2 ---");
        runTest(new RegisterPage());
    }

    public static void runTest(BasePage anyPage) {
        anyPage.waitForPageLoaded();
        anyPage.clickElement("Main Button");
    }
}
