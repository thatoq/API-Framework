package Utils;

import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class HelperMethods
{
    public  static FileInputStream fi;
    public  static FileOutputStream fo;
    public  static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public  static XSSFCell cell;

    public static  int getRowCount(String xlfile,String xlsheet) throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        int rowCount=ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;

    }
    public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        int cellCount=row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }
    public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum)throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlfile);
        row=ws.getRow(rownum);
        cell=row.getCell(colnum);
        String data;
        try
        {
            DataFormatter formatter=new DataFormatter();
            String cellData=formatter.formatCellValue(cell);
            return cellData;

        }
        catch (Exception e)
        {
            data="";
        }
        wb.close();
        fi.close();
        return data;
    }
    public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data)throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        cell=row.createCell(colnum);
        cell.setCellValue(data);
        fo=new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
    @DataProvider(name = "getTestData")
   public Object [][]getTestData()throws IOException
    {
        String path="C:\\WorkSpace\\TestAutomationFramework\\API\\SoapRequest\\SoapData.xlsx";
        int rownum=getRowCount(path,"SC");
        int colcount=getCellCount(path,"SC",1);
        String testData[][]=new String[rownum][colcount];
        for (int i=1;i<=rownum;i++)
        {
            for (int j=0;j<=colcount;j++)
            {
                testData[i-1][j]=getCellData(path,"SC",i,j);
            }
        }
        return (testData);

    }

}
