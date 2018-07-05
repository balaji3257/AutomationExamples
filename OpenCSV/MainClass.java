import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import Pojos.WorldCupModel;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

/**
 * @author balaji3257
 *
 */
public class MainClass {

	
	
	public static void main(String[] args) throws FileNotFoundException {
		mapJavaBeanExample();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void mapJavaBeanExample() throws FileNotFoundException {

		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(WorldCupModel.class);
		String[] columns = new String[] { "years", "winnerCountryName", "looserCountryName", "winningDetails" };
		strat.setColumnMapping(columns);
		CsvToBean csv = new CsvToBean();
		String csvFilename = "C:\\Users\\balaji3257\\eclipse-workspace\\Examples\\files\\worldcup.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		List list = csv.parse(strat, csvReader);
		for (Object object : list) {
			WorldCupModel country = (WorldCupModel) object;
			System.out.print("[" + country.getYears() + "]:[" + country.getWinnerCountryName() + "] Win against [");
			System.out.print(country.getLooserCountryName() + "] by [");
			System.out.println(country.getWinningDetails() + "]");
		}
	}
}
