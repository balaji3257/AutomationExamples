package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import models.Payment;


public class MainClass {

	public static void main(String[] args) throws IOException {
		// LoadDataFromCsvFile.getTestData("C:\\Users\\balaji3257\\eclipse-workspace\\Examples\\OpenCSV\\payment_PROD.csv","VisaCard");
		String csvFilename = "C:\\Users\\balaji3257\\eclipse-workspace\\Examples\\OpenCSV\\payment_PROD.csv";
		mapJavaBeanExample(csvFilename, "VisaCard");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void mapJavaBeanExample(String strFileName, String strReqDataHeader) throws FileNotFoundException {
		String csvFilename = strFileName;
		Payment country ;
		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(Payment.class);
		String[] columns = new String[] { "PaymentType", "CardType", "CardNumber", "NameOnCard", "CreditCardID",
				"ExpirationMonth", "ExpirationYear", "PinNo" };
		strat.setColumnMapping(columns);
		CsvToBean csv = new CsvToBean();
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		List list = csv.parse(strat, csvReader);
		for (Object object : list) {
			 country = (Payment) object;
			if (country.getPaymentType().equalsIgnoreCase(strReqDataHeader)) {
				
			}
		}
	}
}
