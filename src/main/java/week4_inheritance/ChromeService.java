package week4_inheritance;

public class ChromeService implements Browser {
    @Override
    public void open() {
        System.out.println("Mở trình duyệt Google Chrome...");
    }

    @Override
    public void close() {
        System.out.println("Đóng trình duyệt Chrome.");
    }

    @Override
    public void takeScreenshot() {
        System.out.println("Đang chụp màn hình bằng Chrome DevTools...");
    }
}
