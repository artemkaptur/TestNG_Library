package by.htp.library.exampleSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 {

	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\MYPROGRAMS\\DRIVERS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.quizful.net/LoginAction.registration");
		Thread.sleep(2000);

		WebElement loginQuiz = driver.findElement(By.name("registrationForm.login"));
		loginQuiz.sendKeys("ArtemAKkkk");

		WebElement passwordQuiz = driver.findElement(By.name("registrationForm.password"));
		passwordQuiz.sendKeys("ArtemAKkkk");

		WebElement rePasswordQuiz = driver.findElement(By.name("registrationForm.repassword"));
		rePasswordQuiz.sendKeys("ArtemAKkkk");

		WebElement email = driver.findElement(By.name("registrationForm.email"));
		email.sendKeys("test952952985@mail.ru");

		WebElement corporateCheckBox = driver.findElement(By.name("registrationForm.corporate"));
		corporateCheckBox.click();

		WebElement captcha = driver.findElement(By.name("registrationForm.captcha"));

		Thread.sleep(7000);
		captcha.click();

		WebElement submitButton = driver.findElement(By.name("ok"));
		submitButton.click();

		WebElement succesProof = driver.findElement(By.className("content"));
		Assert.assertTrue(succesProof.getText().contains("Регистрация прошла успешно"));

	}
}
