package by.htp.library.exampleSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SimpleTest {

	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\MYPROGRAMS\\DRIVERS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.by");

		Thread.sleep(2000);

		WebElement someElement = driver.findElement(By.name("q"));

		String str = someElement.getTagName();

		System.out.println(str);

		someElement.sendKeys("Java");
		someElement.submit();

		driver.get("https://www.tut.by");

		Thread.sleep(2000);

		WebElement someElement2 = driver.findElement(By.xpath("//*[@id='title_news_block']/div[1]/h3/a/span[1]"));

		String str2 = someElement2.getTagName();
		String text = someElement2.getText();

		System.out.println(str2 + "\n" + text);

		Thread.sleep(5000);
		driver.close();

	}
}
