import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("EPIC")
@Listeners(TestListener.class)
public class LoginTest {

	
	static long overallStartTime = 0L;
	@BeforeSuite
	public void beforeSuite() {
		overallStartTime = System.currentTimeMillis();
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Overall Time taken :" +(System.currentTimeMillis() -overallStartTime) + " milliSeconds");
	}
	
	
	
	@Feature("New")
	@Test(priority = 0, description = "Description for test 1")
	@Story("This is Test1 in Login test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Allure desc from '@Description' Annotation : Test001")
	public void test001() {
		System.out.println("Test Case 001 with Thread Id:- "+ Thread.currentThread().getId());
		stepFunction1("Parameter1");
		stepFunction2();
		stepFunction3();
	}

	
	@Test(priority = 2, description = "Description for test 2")
	@Story("This is Test2 in Login test") @Feature("New")
	@Severity(SeverityLevel.NORMAL)
	@Description("Allure desc from '@Description' Annotation : Test002")
	public void test002() {
		System.out.println("Test Case 002 with Thread Id:- "+ Thread.currentThread().getId());
		
		stepFunction1("Parameter1");
		stepFunction2();
		stepFunction3();
		Assert.assertTrue(false);
	}

	@Feature("Old")
	@Test(priority = 1, description = "Description for test 3")
	@Story("This is Test3 in Login test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Allure desc from '@Description' Annotation : Test003")
	public void test003() {
		System.out.println("Test Case 003 with Thread Id:- "+ Thread.currentThread().getId());
		stepFunction1("Parameter1");
		stepFunction2();
		stepFunction3();
	}

	@Step("This is step function 1 :{0}")
	public static void stepFunction1(String strDesc) {
		
	}

	@Step("This is step function 2 ")
	public static void stepFunction2() {

	}

	@Step("This is step function 3 ")
	public static void stepFunction3() {

	}
}
