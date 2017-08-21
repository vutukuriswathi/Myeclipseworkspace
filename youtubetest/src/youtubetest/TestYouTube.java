package youtubetest;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestYouTube {
	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();

		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "viostreamPlayer_0");

		driver.get("http://splash.abc.net.au/home#!/media/1979231/john-glover-mr-robinson-s-house-on-the-derwent-van-diemen-s-land-1838");

		Thread.sleep(2000L);

		// let the video load
		while (Integer.parseInt(flashApp.callFlashObject("getPlayerState")) == 3) {
			Thread.sleep(1000L);
		}

		// Play the video for 10 seconds
		Thread.sleep(5000);
		flashApp.callFlashObject("pauseVideo");
		Thread.sleep(5000);
		flashApp.callFlashObject("playVideo");
		Thread.sleep(5000);
		flashApp.callFlashObject("seekTo", "140", "true");
		Thread.sleep(5000);
		flashApp.callFlashObject("mute");
		Thread.sleep(5000);
		flashApp.callFlashObject("setVolume", "50");
		Thread.sleep(5000);

	}

}