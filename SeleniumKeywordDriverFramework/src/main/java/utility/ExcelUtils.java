package utility;

import config.Constants;
import executionEngine.DriverScript;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import java.io.IOException;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;


    // 设置Excel文件路径，方便读取到文件
    public static void setExcelFile(String Path) throws Exception {
        try {
            FileInputStream ExcelFile = new FileInputStream(Path);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
        } catch (Exception e){
            Log.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
            DriverScript.bResult = false;
        }
    }

    // 读取Excel文件单元格数据
    // 新增sheetname参数，这样就可以去读取Test Steps和Test Cases两个工作表的单元格数据
    public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
        try{
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        }catch (Exception e){
            Log.error("Class Utils | Method getCellData | Exception desc : "+e.getMessage());
            DriverScript.bResult = false;
            return"";
        }
    }

    //得到一共多少行数据
    public static int getRowCount(String SheetName){
        int iNumber=0;
        try {
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            iNumber=ExcelWSheet.getLastRowNum()+1;
        } catch (Exception e){
            Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
            DriverScript.bResult = false;
        }
        return iNumber;
    }

    //得到测试用例的行号
    public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
        int iRowNum=0;
        try {
            //ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int rowCount = ExcelUtils.getRowCount(SheetName);
            for (; iRowNum<rowCount; iRowNum++){
                if  (ExcelUtils.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
                    break;
                }
            }
        } catch (Exception e){
            Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
            DriverScript.bResult = false;
        }
        return iRowNum;
    }

    //计算一个测试用例有多少个步骤
    public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
        try {
            for(int i=iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++){
                if(!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, SheetName))){
                    int number = i;
                    return number;
                }
            }
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int number=ExcelWSheet.getLastRowNum()+1;
            return number;
        } catch (Exception e){
            Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
            DriverScript.bResult = false;
            return 0;
        }
    }
}
