package Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelSheetUtility {


		XSSFWorkbook wb;
	@DataProvider(name="excelfile")
		public Object [][] dataRead()
		{
		File f1=new File(System.getProperty("user.dir")+"//TestDataProject//TestDataProject.xlsx");
		  FileInputStream fs;
		  Object data[][]=null;
		try {
			fs = new FileInputStream(f1);
			  wb=new XSSFWorkbook(fs);
			  
			  //number of rows
			  int rows=wb.getSheet("Sheet1").getPhysicalNumberOfRows();
			  System.out.println("Number of rows are: "+rows);
			  
			  //number of cells
			  int cells=wb.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells();
			  System.out.println("Number of columns are: "+cells);
			  
			  //create array as per size of file
			   data=new Object[rows-1][cells];//2 ,2
			  for(int i=1;i<rows;i++)//rows
			  {
				  for(int j=0;j<cells;j++)
				  {
					  data[i-1][j]=wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
					  
				  }
				 
			  }
			  
			  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
		 
		  return data;
		}
		  
	}
	
	
	
	

