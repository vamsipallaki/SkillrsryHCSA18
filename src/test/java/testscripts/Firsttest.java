package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.Base_Class;

public class Firsttest extends Base_Class
{

	@Test
	public void firstTest() {
		
		SoftAssert soft=new SoftAssert();
		home.clickGears();
		home.clickSkillrarydemoApp();
		web.handleChildBrowser();
		
		soft.assertEquals(skillraryDemo.getPageHeader(),"Skillraray-ECommers");
		skillraryDemo.mouseHoverTocourse(web);
		skillraryDemo.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
		selenium.doubleClickPlusButton(web);
		selenium.clickAddToCart();
		web.handleAlert();
		
		//soft.assertTrue(selenium.getItemAddedMessage().isDisplayed());
		
		soft.assertAll();
		
		
		
	}
	
}
