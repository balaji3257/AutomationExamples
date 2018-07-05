import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloExample {

	static String csvFile = "C:\\Users\\balaji3257\\Desktop\\UiPathAPI.xlsx";

	public static void main(String[] args) throws FilloException {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(csvFile);
		String strQuery = "Select * from Sheet1";
		Recordset recordset = connection.executeQuery(strQuery);

		while (recordset.next()) {
			System.out.println(recordset.getField("Payload"));
		}
		recordset.close();
		connection.close();
	}
}
