package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Dataprovider {
	
	@org.testng.annotations.DataProvider(name = "dp")
	public Object[][] datareader() throws Exception{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/DataRead2.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowNum= sheet.getPhysicalNumberOfRows();
		int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object [][] arr = new Object[rowNum][colNum];
		
		for(int i=1; i<rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				arr[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return arr;
	}
	
	
	
}
