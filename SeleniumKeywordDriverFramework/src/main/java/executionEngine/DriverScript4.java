//package executionEngine;
//
//import config.ActionsKeywords;
//import config.Constants;
//import utility.ExcelUtils;
//
//import java.lang.reflect.Method;
//
///**
// * @description 第6章中DriverScript文件的代码
// */
//public class DriverScript4 {
//
//    // 声明一个public static的类对象，所以我们可以在main方法范围之外去使用。
//    public static ActionsKeywords actionsKeywords;
//    public static String sActionKeyword;
//    // 下面是返回类型是方法，这里用到反射类
//    public static Method method[];
//
//    // 这里我们初始化'ActionsKeywords'类的一个对象
//    public DriverScript4() throws NoSuchMethodException, SecurityException{
//        actionsKeywords = new ActionsKeywords();
//        method = actionsKeywords.getClass().getMethods();
//    }
//
//    public static void main(String[] args) throws Exception {
//        // 初始化一下DriverScript类
//        DriverScript4 ds = new DriverScript4();
//        String excel_path = Constants.Path_TestData;
//        // 加载读取excel文件
//        ExcelUtils.setExcelFile(excel_path, Constants.Sheet_TestSteps);
//
//        for (int iRow = 1; iRow <= 9; iRow++) {
//            //3表示excel中keyword对应的列的索引，也就是左边数起第4列
//            sActionKeyword = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword);
//            //A调用'execute_Actions'方法
//            execute_Actions();
//        }
//
//    }
//
//
//    private static void execute_Actions() throws Exception {
//        //循环遍历每一个关键字驱动方法（在actionskeywords.java中）
//        //method variable contain all the method and method.length returns the total number of methods
//        // 下面methid.length表示方法个数，method变量表示任何一个关键字方法，例如openBrowser()
//        for(int i = 0;i < method.length;i++){
//            //开始对比代码中关键字方法名称和excel中关键字这列值是否匹配
//            if(method[i].getName().equals(sActionKeyword)){
//                //一点匹配到相关关键字方法，就会调用对应的关键字静态方法
//                method[i].invoke(actionsKeywords);
//                //一旦任何关键字被执行，利用break语句去跳出for循环。
//                break;
//            }
//        }
//    }
//}
