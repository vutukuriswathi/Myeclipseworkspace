package testCases;

import org.testng.annotations.Test;

import abcRadio.HomePageABCRadio;
import abcRadio.LaunchABCRadio;
import abcRadio.MediaPlayerRadio;
import abcRadio.NavigateToSubMenu;
import abcRadio.SocialMediaIcons;
import base.BasePage;

public class TestABCRadio extends BasePage {

	/*
	 * 1) Verify can navigate to a ‘Program’ (e.g. ‘Big Ideas’) from the
	 * Programs sub-menu. Url: http://www.abc.net.au/radionational/
	 * 
	 */
	@Test(priority = 1)
	public static void LaunchABCRadioAndValidate() throws InterruptedException {
		LaunchABCRadio.launchRadioApplication();
		LaunchABCRadio.validatePageLoad();
		NavigateToSubMenu.navigateToBigIdea();
	}

	/*
	 * Point 2: Navigate to the last item in the ‘Program guide’ banner
	 * (underneath the primary navigation) and select the last program.
	 */
	@Test(priority = 2)
	public static void ProgramGuideTest() throws InterruptedException {
		LaunchABCRadio.launchRadioApplication();
		HomePageABCRadio.programGuide();
	}

	/*
	 * Point 3: Verify can search for content in the search bar and that content
	 * is returned.
	 */
	@Test(priority = 3)
	public static void SearchContentAndValidate() throws InterruptedException {
		LaunchABCRadio.launchRadioApplication();
		HomePageABCRadio.ValidateSearchContent(null);
	}

	/*
	 * Point 4: Verify you can click on Social media ‘Share’ icon and the
	 * correct pop-up appears:
	 */
	@Test(priority = 4)
	public static void SocialMediaIconTest() throws InterruptedException {
		LaunchABCRadio.NavigateToRadioTestPage();
		HomePageABCRadio.ScrollFeature();
		SocialMediaIcons.ValidateTwitterIcon();
		HomePageABCRadio.ScrollFeature();
		SocialMediaIcons.ValidateFacebookIcon();
	}

	/*
	 * Point 5: Verify that when you click on ‘Download audio’ you are directed
	 * to the mp3 file (will play in browser unless right click and select
	 * Download):
	 * http://www.abc.net.au/radionational/programs/bigideas/being-creative-in-
	 * the-digital-age/8737858
	 * http://www.abc.net.au/radionational/programs/bigideas/a-fortunate-
	 * universe/8076406 --> Segment has expired
	 * 
	 * 
	 */
	@Test(priority = 5)
	public static void DownloadAudioTest() throws InterruptedException {
		LaunchABCRadio.NavigateToRadioTestPage();
		MediaPlayerRadio.DownloadAudioFeature();
	}

	/*
	 * Point 6: Verify that when you click on ‘Listen now’ (from previous url)
	 * you are re-directed to the following url:
	 * http://www.abc.net.au/radionational/programs/bigideas/being-creative-in-
	 * the-digital-age/8737858
	 * https://radio.abc.net.au/programitem/pel3PKe2MD?play=true
	 * https://radio.abc.net.au/programitem/pg1aGbWlx6?play=true --> Segment has
	 * expired
	 */
	@Test(priority = 6)
	public static void ListenAudioTest() throws InterruptedException {
		LaunchABCRadio.NavigateToRadioTestPage();
		MediaPlayerRadio.ListenAudioFeature();
	}

	/*
	 * 7) Verify that the audio player loads successfully when you load url:
	 * https://radio.abc.net.au/programitem/pel3PKe2MD?play=true
	 * https://radio.abc.net.au/programitem/pg1aGbWlx6?play=true --> Segment has
	 * expired
	 */
	@Test(priority = 7)
	public static void ValidateListenAudioTest() throws InterruptedException {
		MediaPlayerRadio.ValidateAudioPlayer();
		MediaPlayerRadio.CloseAudioPlayer();
	}

}