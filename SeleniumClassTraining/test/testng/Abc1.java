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

public class Abc1 {
  @Test
  public void acb1() {
	  System.out.println("Inside abc1 Test1 in class Abc1");
  }
  @Test
  public void acb2() {
	  System.out.println("Inside abc2 Test1 in class Abc1");
  }
  @Test
  public void acb3() {
	  System.out.println("Inside abc3 Test1 in class Abc1");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside before Method in class Abc1");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside after Method  in class Abc1");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside before Class in class Abc1");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside after Class in class Abc1");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside beforeTest in class Abc1");
	  System.out.println("-------------------------------------------------------------------------------");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside afterTest in class Abc1");
	  System.out.println("-------------------------------------------------------------------------------");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside before Suite in class Abc1");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside after Suite in class Abc1");
  }

}
