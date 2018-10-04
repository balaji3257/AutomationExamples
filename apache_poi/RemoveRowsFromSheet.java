import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFSheet;

public class RemoveRowsFromSheet {

	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\balaji3257\\Desktop\\dt.xlsx";

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		removeEmptyRows(SAMPLE_XLSX_FILE_PATH);
	}

	public static void removeEmptyRows(String ExcelFileName) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		Workbook workbook = WorkbookFactory.create(new File(ExcelFileName));

		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		Sheet sheet = workbook.getSheetAt(3); 
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			boolean isRowEmpty;
			if (sheet.getRow(i) == null) {
				sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
				i--;
				continue;
			}
			final Row actualRow = sheet.getRow(i);
			isRowEmpty = actualRow.getCell(1).toString().trim().equals("");
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
	
    public static void deleteEmptyRows(String ExcelFileName) throws EncryptedDocumentException, InvalidFormatException, IOException{
    	Workbook workbook = WorkbookFactory.create(new File(ExcelFileName));

		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

//		Sheet sheet = workbook.getSheetAt(3); 
        SXSSFSheet sheet = (SXSSFSheet) workbook.getSheetAt(3);
        for ( int r=sheet.getLastRowNum(); r >= 0; r-- ){
            Row row     = sheet.getRow( r );

            // if no row exists here; then nothing to do; next!
            if ( row == null )
                continue;

            int lastColumn = row.getLastCellNum();
            boolean rowToDelete = true;
            if(lastColumn > -1){
                for ( int x=0; x < lastColumn + 1; x++ ){
                    Cell cell    = row.getCell(x);
                    if ( cell != null && cell.getStringCellValue() != null){
                        String cellTrimValue = cell.getStringCellValue().trim();
                        if(!cellTrimValue.isEmpty()){
                            rowToDelete = false;
                            break;
                        }
                    }
                }
            }

            if(rowToDelete){
                if(r == sheet.getLastRowNum()){
                    sheet.removeRow(row);
                }else{
                    sheet.removeRow(row);
                    for(int j= r+1; j <= sheet.getLastRowNum(); j++){
                        Row rowToShift = sheet.getRow(j);
                        rowToShift.setRowNum(j-1);
                    }
                }
            }
        }
    }

	public static void removeRows(String ExcelFileNae)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(ExcelFileNae));

		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		Sheet sheet = workbook.getSheetAt(3);
		Row row = sheet.getRow(3);
		/*
		 * if (row == null) { // sheet.removeRow(sheet.getRow(i)); sheet.shiftRows(0 +
		 * 1, sheet.getLastRowNum(), -1); } sheet.removeRow(row);
		 */

		int rowIndex = 3;
		int lastIndex = sheet.getLastRowNum();
		sheet.shiftRows(rowIndex + 1, lastIndex, -1);

		lastIndex = sheet.getLastRowNum();
	}
}
