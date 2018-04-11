package by.htp.library.exampleSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task1 {

	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\MYPROGRAMS\\DRIVERS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://oz.by");
		Thread.sleep(2000);

		WebElement someElement = driver.findElement(By.name("q"));

		someElement.sendKeys("Java");
		someElement.submit();

		List<WebElement> listElements = driver.findElements(By.className("item-type-card__title"));

		for (WebElement elem : listElements) {
			System.out.println(elem.getText());
		}

		System.out.println(listElements.size());

		Thread.sleep(5000);
		driver.close();

	}
}
