import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\balaji3257\\Desktop\\dt.xls";

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		readExcelFile(SAMPLE_XLSX_FILE_PATH);
	}

	private static  void removeEmptyRows(final Sheet sheet) {
		
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			System.out.println("Removing empty rows at : "+ i);
			boolean isRowEmpty;
			if (sheet.getRow(i) == null) {
//				sheet.removeRow(sheet.getRow(i));
				sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
				i--;
				continue;
			}
			final Row actualRow = sheet.getRow(i);
			//isRowEmpty = actualRow.getCell(1).toString().trim().equals("");
			isRowEmpty = isEmpty(actualRow);
			if (isRowEmpty) {
				if (i == sheet.getLastRowNum()) {
					sheet.removeRow(actualRow);
				} else {
					sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
				}
				i--;
			}
		}
	}

	public static boolean isEmpty(Row row) {
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
				return false;
		}
		return true;
	}

	public static void readExcelFile(String strExcelFileNameAsString)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(strExcelFileNameAsString));

		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		/*
		 * Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		 * System.out.println("Retrieving Sheets using Iterator"); while
		 * (sheetIterator.hasNext()) { Sheet sheet = sheetIterator.next();
		 * System.out.println("=> " + sheet.getSheetName()); }
		 * 
		 * // 2. Or you can use a for-each loop
		 * System.out.println("Retrieving Sheets using for-each loop"); for (Sheet sheet
		 * : workbook) { System.out.println("=> " + sheet.getSheetName()); }
		 */

		// 1. You can obtain a rowIterator and columnIterator and iterate over them
		Sheet sheet = workbook.getSheetAt(3);
		DataFormatter dataFormatter = new DataFormatter();
		System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			System.out.print("Is Row Empty "+ isEmpty(row));
			// Now let's iterate over the columns of the current row
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.print(cellValue + "\t");
			}
			System.out.println();
		}

		
		removeEmptyRows(sheet);
	}
}
