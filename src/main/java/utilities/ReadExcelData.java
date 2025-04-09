package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	String path ="G:\\Exam2024\\PracticeExam\\src\\test\\resources\\testData\\testData.xlsx";
	
	public String getData(int Row, int Column) throws EncryptedDocumentException, IOException {
		
		FileInputStream fs = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(Row);
		Cell cell = row.getCell(Column);
		
		String data= cell.getStringCellValue();
		System.out.print(data);
		return data;
	  }
	}
