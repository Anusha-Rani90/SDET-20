package pac1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\Anusha\\Desktop\\testscript.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		
		int count =sh.getLastRowNum();
		
		for(int i=0;i<count;i++)
		{
			Row row=sh.getRow(i);
			String firstColData= row.getCell(0).getStringCellValue();
			String secondColData= row.getCell(1).getStringCellValue();
			System.out.println(firstColData + "\t" + secondColData);
		}

	}

}
