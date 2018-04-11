package by.htp.library.exampleSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task4 {

	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\MYPROGRAMS\\DRIVERS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.quizful.net/LoginAction.loginForm");
		Thread.sleep(2000);

		WebElement login = driver.findElement(By.name("loginForm.login"));
		login.sendKeys("ArtemAKa");

		WebElement password = driver.findElement(By.name("loginForm.password"));
		password.sendKeys("ArtemAKa");

		WebElement rememberMeButton = driver.findElement(By.name("loginForm.rememberMe"));
		rememberMeButton.click();

		WebElement submitButton = driver.findElement(By.name("ok"));
		submitButton.click();

		WebElement succesProof = driver.findElement(By.xpath("//*[@id='user-panel']/li[1]/b/a"));
		succesProof.click();

		WebElement editProfile = driver.findElement(By.xpath("//*[@id=\'middle\']/div[2]/div[1]/div[2]/div/a"));
		editProfile.click();

		WebElement personalData = driver.findElement(By.xpath("//*[@id=\'profile-personal-form\']/div[2]/b"));
		personalData.click();

		WebElement name = driver.findElement(By.name("personalForm.name"));
		name.sendKeys("Artem");

		WebElement surname = driver.findElement(By.name("personalForm.surname"));
		surname.sendKeys("Kraken");

		WebElement birthDate = driver.findElement(By.name("personalForm.birthyear"));
		birthDate.sendKeys("1994");

		WebElement site = driver.findElement(By.name("personalForm.site"));
		site.sendKeys("htp.by");

		WebElement company = driver.findElement(By.name("personalForm.company"));
		company.sendKeys("htp");		

	}
}
