import org.fluttercode.datafactory.impl.DataFactory;

public class TestDataGeneratorExample {

	
	
	
	
	public static void main(String[] args) {
		DataFactory generate = new DataFactory();
		String strEnvName = generate.getRandomText(8);
		String strEnvDesc = generate.getAddress();
		
		System.out.println(strEnvDesc);
		
		System.out.println(strEnvName);
	}
	
	
}
