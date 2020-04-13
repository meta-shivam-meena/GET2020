
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Counselling {
	public static void main(String[] args) throws Exception {
		HSSFWorkbook wb = null;
		HSSFWorkbook wb1 = null;
		HSSFWorkbook wb2 = null;
		try {
			HashMap<String, Double> offeredPrograms = new HashMap<String, Double>();

			// obtaining input bytes from a file
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Shivam\\Desktop\\GET2020\\Data Structures and Algorithms\\DS_Session2\\OfferedPrograms.xls");
			// creating workbook instance that refers to .xls file
			wb = new HSSFWorkbook(fis);
			// creating a Sheet object to retrieve the object
			HSSFSheet sheet = wb.getSheetAt(0);
			for (Row row : sheet) {
				offeredPrograms.put(row.getCell(0).getStringCellValue(), row
						.getCell(1).getNumericCellValue());
			}
			
			wb1 = new HSSFWorkbook();
			HSSFSheet resultSheet = wb1.createSheet("result");
			int rowNumber = -1;
			
			FileInputStream fis2 = new FileInputStream(
					"C:\\Users\\Shivam\\Desktop\\GET2020\\Data Structures and Algorithms\\DS_Session2\\StudentChoices.xls");
			wb2 = new HSSFWorkbook(fis2);
			HSSFSheet sheet2 = wb2.getSheetAt(0);
			for (Row row : sheet2) {
				String name = row.getCell(0).getStringCellValue();
				Row resultRow = resultSheet.createRow(++rowNumber);
				Cell resultStudentName = resultRow.createCell(0);
				resultStudentName.setCellValue(name);
				for (int i = 1; i <= 3; i++) {
					String choice = row.getCell(i).getStringCellValue();
					Double seatsLeft = offeredPrograms.get(choice);
					if (seatsLeft != null && seatsLeft > 0.5) {
						offeredPrograms.put(choice, seatsLeft - 1);
						Cell resultProgramGot = resultRow.createCell(1);
						resultProgramGot.setCellValue(choice);
						break;
					}
				}
			}
			
			FileOutputStream outputStream = new FileOutputStream("Result.xlsx");
			wb1.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wb != null) {
				wb.close();
			}
			if (wb1 != null) {
				wb1.close();
			}
			if (wb2 != null) {
				wb2.close();
			}
		}
	}
}
