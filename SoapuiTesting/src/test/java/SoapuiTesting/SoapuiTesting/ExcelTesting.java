package SoapuiTesting.SoapuiTesting;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ExcelTesting {

	@Test
	public void test1() throws IOException {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Workbook workbook = new XSSFWorkbook(loader.getResourceAsStream("com/TestData.xlsx"));
		Sheet firstSheet = workbook.getSheetAt(0);
		Row rowData = firstSheet.getRow(2);
		System.out.println((int) rowData.getCell(2).getNumericCellValue() == 0);
	}

}
