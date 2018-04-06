package by.htp.library.dao;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExampleTest {
	
	@BeforeSuite
	public void m0()
	{
		System.out.println("BeforeSuite");		
	}
	
	@BeforeClass
	public void m1()
	{
		System.out.println("BeforeClass");	
	}
	
	@BeforeTest
	public void m2()
	{
		System.out.println("BeforeTest");	
	}
	
	@BeforeMethod
	public void m3()
	{
		System.out.println("BeforeMethod");	
	}
	
	@Test
	public void testSmth1()
	{
		Assert.assertEquals("a", "a", "a equal a");
	}
	
	@Test
	public void testSmth2()
	{
		Assert.assertEquals("b", "b", "b !equal b");
	}
	
	@Test
	public void testSmth3()
	{
		Assert.assertEquals("c", "d", "c !equal d");
	}
	
	@AfterSuite
	public void m4()
	{
		System.out.println("AfterSuite");		
	}
	
	@AfterClass
	public void m5()
	{
		System.out.println("AfterClass");	
	}
	
	@AfterTest
	public void m6()
	{
		System.out.println("AfterTest");	
	}
	
	@AfterMethod
	public void m7()
	{
		System.out.println("AfterMethod");	
	}

}
