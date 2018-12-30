package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static executionEngine.DriverScript5.OR;

public class ActionsKeywords {

    public static WebDriver driver;

    /**
     * 以下方法，我们针对dataEngine.xlsx文件中的action_keyword这列的关键字都进行封装
     * 等关键字框架快设计完了，我们再来调整，读取配置文件去启动不同测试浏览器和测试地址
     * 这样就不会代码写死这两个参数。
     */
//    public static void openBrowser() {
//
//        // 这里，我们暂时都写死用chrome来进行自动化测试
//        System.setProperty("webdriver.chrome.driver",".\\libs\\chromedriver.exe");
//        driver = new ChromeDriver();
//    }

//    public static void openUrl() {
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////        driver.get("https://www.baidu.com");  // 第3章中的代码
//        driver.get(Constants.URL);  // 第6章中的代码，替代上面的代码
//
//    }

//    public static void click_Login_link() {
//        driver.findElement(By.xpath(".//*[@id='u1']/a[text()='登录']")).click();
//        driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
//    }

//    public static void input_Username() {
//
////        driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("xxxxx");   // 第3章中的代码
//        driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys(Constants.UserName);  // 第6章中的代码，替代上面的代码
//    }

//    public static void input_Password() {
//
////        driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("xxxxx");   // 第3章中的代码
//        driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys(Constants.Password);  // 第6章中的代码，替代上面的代码
//    }

//    public static void click_Submit() {
//        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
//    }

    // 关闭浏览器并退出
    public static void closeBrowser() {
        driver.quit();
    }
    // 下面的代码是第7章中的优化代码

    /**
     *封装一个click（）方法和input（）方法，重点是click()的实现过程
     *这里提一下openUrl和openBrowser方法中为什么也要传入string参数，但是代码没有用到这个参数
     *这个主要是我们在excel对应单元格不填写，那么获取的string对象就是null，所以这里参数String object不会影响方法执行 
     */
    public static void openBrowser(String object) {

        // 这里，我们暂时都写死用chrome来进行自动化测试
        System.setProperty("webdriver.chrome.driver",".\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void openUrl(String object) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Constants.URL);

    }

    public static void click(String object) {
        driver.findElement(By.xpath(OR.getProperty(object))).click();
    }

    public static void input(String object) {
        driver.findElement(By.id(OR.getProperty(object))).sendKeys(Constants.UserName);
    }


    public static void waitFor() throws Exception{
        Thread.sleep(3000);
    }

}
