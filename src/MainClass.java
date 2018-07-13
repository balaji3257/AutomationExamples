
public class MainClass {

	static String strReplaceToken ="<<<>>>";
	
	public static void main(String[] args) {
		String xpath = "Xpath&//div[@id='menu-section']";
		System.out.println( getLocType(xpath) );
	}
	
	
	private static String getLocType(String strObjectLocator) {
		return strObjectLocator.split("&")[0].trim();
	}
	
	private static String replaceXpathVariables(String strObjectLocator, String strReplaceValue) {
		String strRepalcedLocator = strObjectLocator.replace(strReplaceToken, strReplaceValue);
		return strRepalcedLocator;
	}
}
