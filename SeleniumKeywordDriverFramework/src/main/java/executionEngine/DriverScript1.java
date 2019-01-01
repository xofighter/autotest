//package executionEngine;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @description 第2章中DriverScript文件的代码
// */
//public class DriverScript1 {
//
//    private static WebDriver driver = null;
//
//    public static void main(String[] args) throws InterruptedException {
//
//        System.setProperty("webdriver.chrome.driver",".\\libs\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//        driver.get("https://www.baidu.com");
//        Thread.sleep(2000);
//
//        // 点击登录链接
//        driver.findElement(By.xpath(".//*[@id='u1']/a[text()='登录']")).click();
//
//        // 点击账号密码登录
//        driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
//
//        driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("xxxxx");
//        driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("xxxxx");
//        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
//
//    }
//}
