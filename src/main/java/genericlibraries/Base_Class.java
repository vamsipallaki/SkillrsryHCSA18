package genericlibraries;


	
	

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactUspage;
import pompages.CoreJavaForSeleniumPage;
import pompages.CoreJavaVedioPage;
import pompages.Homepage;
import pompages.SeleniumTrainingPage;
import pompages.SkillraryDemoAppPage;
import pompages.TestingPage;

	public class Base_Class 
	{
		protected Propertiesutilitys property;
		protected Excelutility excel;
		protected WebDriverUtility web;
		protected WebDriver driver;
		protected Homepage home;
		protected SkillraryDemoAppPage skillraryDemo;
		protected SeleniumTrainingPage selenium;
		protected CoreJavaForSeleniumPage corejava;
		protected CoreJavaVedioPage javavideo;
		protected TestingPage testing;
		protected ContactUspage contact;
		
		
		//@BeforeSuite
		//@BeforeTest
		@BeforeClass
		 public void classConfiguration()
		 {
			 property= new Propertiesutilitys();
			 excel= new Excelutility();
			 web= new WebDriverUtility();
			 
			 property.propertuesInitialization(IconstantPath.PROPERTIES_FILE_PATH);
			 excel.excelInitialization(IconstantPath.EXCEL_FULE_PATH);
			 
			 
			 
		 }
		@BeforeMethod
		public void methodConfiguration()
		{
			long time= Long.parseLong(property.fetchProperty("timeouts"));
			 driver=web.openApplication(property.fetchProperty("browser"), 
					 property.fetchProperty("url"), time);
			 
			 home= new Homepage(driver);
			 Assert.assertTrue(home.getLogo().isDisplayed());
			 skillraryDemo= new SkillraryDemoAppPage(driver);
			 selenium=new SeleniumTrainingPage(driver);
			 corejava=new CoreJavaForSeleniumPage(driver);
			 javavideo=new CoreJavaVedioPage(driver);
			 testing=new TestingPage(driver);
			 contact = new ContactUspage(driver); 
			 
		}
		@AfterMethod
		public void methodTearDown()
		{
			web.quitBrowser();
		}
		@AfterClass
		public void classTearDown()
		{
			excel.closeExcel();
		}
		//@AfterTest
		//@AfterSuite
	}





	


