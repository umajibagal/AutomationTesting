package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Abc5 {
  @Test
  public void acb5() {
	  System.out.println("Inside abc5 Test in class Abc5");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside before Method in class Abc5");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside after Method  in class Abc5");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside before Class in class Abc5");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside after Class in class Abc5");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside beforeTest in class Abc5");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside afterTest in class Abc5");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside before Suite in class Abc5");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside after Suite in class Abc5");
  }

}
