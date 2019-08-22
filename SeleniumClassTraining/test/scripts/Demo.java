package scripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Demo {
	
	public static void main(String[] args) {
		RemoteWebDriver dr=null;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		try {
			 dr = new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dr.get("http://www.google.com");
	}
}
