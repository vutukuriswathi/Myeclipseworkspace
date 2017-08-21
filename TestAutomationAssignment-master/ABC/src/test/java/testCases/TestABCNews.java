package testCases;

import org.testng.annotations.Test;

import abcNews.HomePageABCNews;
import abcNews.JustInPageABCNews;
import abcNews.PhotoGalleryPageABCNews;
import abcNews.VideoPageABCNews;
import base.BasePage;

public class TestABCNews extends BasePage {

	/*
	 * Point 1: Verify that the page loads successful
	 */
	@Test(priority = 1)
	public void LaunchABCNewsAndValidate() {
		HomePageABCNews.launchApplication();
		HomePageABCNews.validatePageLoad();
	}

	/*
	 * Point 2: Verify that News banner loads
	 */
	@Test(priority = 2)
	public void ValidateABCNewsBanner() {
		HomePageABCNews.validateNewsBanner();
	}

	/*
	 * Point 3: Verify can navigate to the ‘Just In’ page via the link on the
	 * primary navigation.
	 */
	@Test(priority = 3)
	public void LoadJustInMenu() throws InterruptedException {
		JustInPageABCNews.navigateToJustInMenu();
	}

	/*
	 * 4) Verify that on the ‘Just In’ page (http://www.abc.net.au/news/justin/)
	 * that the content per article loads correctly, i.e. must contain: 1. Title
	 * 2. Time stamp 3. Text
	 */
	@Test(priority = 4)
	public void JustInMenuPageContentValidation() throws InterruptedException {
		JustInPageABCNews.validateJustInPageContent();
	}

	/*
	 * Point 5: Verify that a video loads and appears successfully on the
	 * following page
	 * http://www.abc.net.au/news/2017-02-09/weatherill-promises-to-intervene-
	 * dramatically/8254908
	 */
	@Test(priority = 5)
	public void ABCSNewsVideoTest() throws InterruptedException {
		VideoPageABCNews.launchVideoPage();
		VideoPageABCNews.validatePageLoad();
		VideoPageABCNews.testVideo();
	}

	/*
	 * Point 6: Verify that the Image Gallery successfully loads and images
	 * appear correctly: Url:
	 * http://www.abc.net.au/news/2017-02-10/abc-open-pic-of-the-week/8256256
	 */
	@Test(priority = 6)
	public void ABCNewsGallaryTest() throws InterruptedException {
		PhotoGalleryPageABCNews.launchPhotoGallaryPage();
		PhotoGalleryPageABCNews.validatePageLoad();
		PhotoGalleryPageABCNews.validateContent();
	}

}
