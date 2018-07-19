import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class MainClass {

	static String strReplaceToken ="<<<>>>";
	static String userDir = System.getProperty("user.dir");
	
	public static void main(String[] args) throws IOException {

		genAllurereport();
	}
	
	
	private static String getLocType(String strObjectLocator) {
		return strObjectLocator.split("&")[0].trim();
	}
	
	private static String replaceXpathVariables(String strObjectLocator, String strReplaceValue) {
		String strRepalcedLocator = strObjectLocator.replace(strReplaceToken, strReplaceValue);
		return strRepalcedLocator;
	}
	
	
	private static void generateAllureReports() throws IOException {
		
		System.out.println(userDir);
		String command = "cd C:\\Users\\balaji3257\\eclipse-workspace\\AppiumMobileTabletWeb";
		
		 Process child = Runtime.getRuntime().exec(command);
//		 ProcessBuilder builder = new ProcessBuilder(command);
		 
//		 builder.redirectErrorStream(true);
//	        Process p = builder.start();
	        BufferedReader r = new BufferedReader(new InputStreamReader(child.getInputStream()));
	        String line;
	        while (true) {
	            line = r.readLine();
	            if (line == null) { break; }
	            System.out.println(line);
	        }
	}
	
	
	
	private static void  generateAllure() {
		try {
		    // Execute command
//			 String command = "java -version";
		    String command = "cmd /c start cmd.exe";
//		    String command ="cd C:\\Users\\balaji3257\\eclipse-workspace\\AppiumMobileTabletWeb alure serve allure-results";
		    Process child = Runtime.getRuntime().exec(command);

		    // Get output stream to write from it
		    OutputStream out = child.getOutputStream();

		    out.write("cd C:\\Users\\balaji3257\\eclipse-workspace\\AppiumMobileTabletWeb /r/n".getBytes());
		    out.flush();
		    out.write("dir /r/n".getBytes());
		    out.close();
		    
		   
		} catch (IOException e) {
		}
	}
	
	
	private static void genAllurereport() {

        try {
            Runtime rt = Runtime.getRuntime();
//            Process pr = rt.exec("cmd /c cd C:\\\\Users\\\\balaji3257\\\\eclipse-workspace\\\\AppiumMobileTabletWeb /c dir");
//            Process pr = rt.exec("c:\\helloworld.exe");
            Process pr = rt.exec("C:\\Users\\balaji3257\\Desktop\\GenReport.bat "+userDir);

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line=null;

            while((line=input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code "+exitVal);

        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
	
}
