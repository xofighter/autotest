package config;

import org.openqa.selenium.By;

public class Constants {

    // 这里定义为public static的类型，方便其他任何类进行访问和调用
    public static final String URL = "https://www.baidu.com";
    public static final String Path_TestData = ".//src//dataEngine//dataEngine.xlsx";
    public static final String File_TestData = "dataEngine.xlsx";

    //OR(对象仓库)文件路径
    public static final String Path_OR ="D:\\eclipse-workspace\\autotest\\SeleniumKeywordDriverFramework\\src\\main\\java\\config\\OR.txt";

    // dataEngine.xlsx中一些单元格的索引值
    public static final int Col_TestCaseID = 0;
    public static final int Col_TestScenarioID =1 ;
    public static final int Col_PageObject =3 ;
    public static final int Col_ActionKeyword =4 ;
    public static final int Col_RunMode =2 ;

    // 第一个是测试用例结果标记列的索引，第二个是测试步骤里面的结果列索引
    public static final int Col_Result =3 ;
    public static final int Col_TestStepResult =5 ;

    // DataEngmine.excel中sheet的名称
    public static final String Sheet_TestSteps = "Test Steps";
    // 第二个工作簿的名称
    public static final String Sheet_TestCases = "Test Cases";

    // 测试登录用到的用户数据
    public static final String UserName = "天麻鸭";
    public static final String Password = "Qwert9632";

    // 结果状态标记
    public static final String KEYWORD_FAIL = "FAIL";
    public static final String KEYWORD_PASS = "PASS";

    // ep专用
    public static final String URLep = "http://abc.e-ports.com/zh-Hans-CN/login";
    public static final String xpath_UserName = "//*[@id=\"username\"]";
    public static final String xpath_Password = "//*[@id=\"password\"]";
    public static final String xpath_Submit = "//*[@id=\"content\"]/div/div[2]/div[2]/div/div[2]/form/div[3]/div/div/button";

}
