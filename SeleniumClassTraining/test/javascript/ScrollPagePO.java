package javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollPagePO {
	WebDriver driver;

	
	public ScrollPagePO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void scrollPageTest() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript(script, args)
		System.out.println("Hello form js");
	}
	

}
