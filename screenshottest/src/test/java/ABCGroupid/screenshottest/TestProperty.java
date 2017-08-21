package ABCGroupid.screenshottest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class TestProperty {

	@Test
	public void test1() throws FileNotFoundException, IOException {

		Properties p1 = new Properties();
		FileOutputStream out = new FileOutputStream(
				System.getProperty("user.dir") + "/src/test/java/ABCGroupid/screenshottest/test1.properties");
		p1.load(new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/ABCGroupid/screenshottest/test1.properties"));
		p1.setProperty("top1", "modified");
		p1.store(out, null);
	}

}
