

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class JsExecutorReturn {

	static WebDriver browser;
	public static void main(String[] args) throws InterruptedException {
		JsExecutorReturn.test();
	}
	
	public static void test() throws InterruptedException {
		System.out.println("Test Started");
		System.setProperty("webdriver.chrome.driver", "E:\\tools\\browserEngines\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("http://google.com");	
		Thread.sleep(4000);
		JavascriptExecutor jsExec = (JavascriptExecutor) browser;
		String WebAppTitle = jsExec.executeScript("return window.getComputedStyle(document.getElementById('lst-ib'))").toString();
//		jsExec.executeScript("document.getElementById('lst-ib').value='Map'");
		System.out.println("ComputedCSSDetails: "+WebAppTitle);
		
		browser.close();
		System.out.println("Test Completed");
	}
}
