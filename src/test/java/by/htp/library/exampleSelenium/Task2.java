package by.htp.library.exampleSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task2 {

	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\MYPROGRAMS\\DRIVERS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.by");

		Thread.sleep(2000);

		WebElement someElement = driver.findElement(By.name("q"));

		someElement.sendKeys("Java");
		someElement.submit();

		List<WebElement> listElements = driver.findElements(By.xpath("//*[@id='rso']/div/div/div/div/div/h3/a"));

		for (WebElement elem : listElements) {
			if (!(elem.getText().contains("Java") || elem.getText().contains("JAVA"))) {
				System.out.println("Element " + elem.getText() + "doesn't contain 'Java'!!!");
			}

			System.out.println(elem.getText());
		}

		System.out.println("Count of finded elements: " + listElements.size());

		Thread.sleep(5000);
		driver.close();

	}
}
