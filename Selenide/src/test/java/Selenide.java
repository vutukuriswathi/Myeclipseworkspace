
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Selenide {

	@Test
	public void testcase1() throws InterruptedException {
		open("http://www.google.com");

		$(By.className("gsfi")).sendKeys("swathi");
		$(By.className("gsfi")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}
}