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

public class Abc4 {
  @Test
  public void acb4() {
	  System.out.println("Inside abc4 Test in class Abc4");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside before Method in class Abc4");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside after Method  in class Abc4");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside before Class in class Abc4");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside after Class in class Abc4");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside beforeTest in class Abc4");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside afterTest in class Abc4");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside before Suite in class Abc4");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside after Suite in class Abc4");
  }

}
