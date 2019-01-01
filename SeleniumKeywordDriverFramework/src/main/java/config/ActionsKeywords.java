package config;

import executionEngine.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Log;

import java.util.concurrent.TimeUnit;

import static executionEngine.DriverScript.OR;

public class ActionsKeywords {

    /**
     * 以下方法，我们针对dataEngine.xlsx文件中的action_keyword这列的关键字都进行封装
     * 等关键字框架快设计完了，我们再来调整，读取配置文件去启动不同测试浏览器和测试地址
     * 这样就不会代码写死这两个参数。
     */

    /**
     *封装一个click（）方法和input（）方法，重点是click()的实现过程
     *这里提一下openUrl和openBrowser方法中为什么也要传入string参数，但是代码没有用到这个参数
     *这个主要是我们在excel对应单元格不填写，那么获取的string对象就是null，所以这里参数String object不会影响方法执行 
     */
    public static WebDriver driver;

    public static void openBrowser(String object) {

        // 这里，我们暂时都写死用chrome来进行自动化测试
        try{
            Log.info("启动chrome浏览器。");
            System.setProperty("webdriver.chrome.driver",".\\libs\\chromedriver.exe");
            driver = new ChromeDriver();
        }catch(Exception e){
            Log.info("无法启动浏览器 --- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }

    public static void openUrl(String object) {

        try{
            Log.info("打开测试环境地址");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(Constants.URL);
        }catch(Exception e){
            Log.info("无法打开测试环境地址 --- " + e.getMessage());
            DriverScript.bResult = false;
        }

    }

    public static void click(String object) {
        try{
            Log.info("点击元素： "+ object);
            driver.findElement(By.xpath(OR.getProperty(object))).click();
        }catch(Exception e){
            Log.error("无法点击元素--- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }

    public static void inputUsername(String object){
        try{
            Log.info("在用户名输入框输入文字");
            driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.UserName);
        }catch(Exception e){
            Log.error("无法输入用户名 --- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }

    public static void inputPassword(String object){
        try{
            Log.info("密码框输入...");
            driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.Password);
        }catch(Exception e){
            Log.error("密码框无法输入--- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }

    public static void waitFor(String object) throws Exception{
        try{
            Log.info("等待五秒");
            Thread.sleep(5000);
        }catch(Exception e){
            Log.error("无法等待 --- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }

    public static void closeBrowser(String object){
        try{
            Log.info("关闭并退出浏览器");
            driver.quit();
        }catch(Exception e){
            Log.error("无法关闭浏览器--- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }

}
