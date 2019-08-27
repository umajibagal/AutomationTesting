package javascript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import testbase.TestBaseClass;

public class ScrollPage extends TestBaseClass{
	
	WebDriver driver;
	@Test
	public void scrollPageTest() { 
	
		ScrollPagePO sp = PageFactory.initElements(driver,ScrollPagePO.class);
		sp.scrollPageTest();
		
	}
	

}
