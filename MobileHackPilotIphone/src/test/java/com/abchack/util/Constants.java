package com.abchack.util;

public class Constants {

	public static final String username = "username";

	// PATHS
	public static final String Config_File_Path = System.getProperty("user.dir")
			+ "//src//test//java//com//abchack//config//config.properties";

	public static final long shortWait = 2000L;

	public static final long longWait = 5000L;

	// internet explorer exe path
	public static final String ie_exe_path = "";

	// chrome exe path
	public static final String chrome_exe_path = "/Users/gunuputis4r/Documents/Browsersdrivers/chromedriver";

	// safari exe path
	public static final String safari_exe_path = "";

	// channel page url
	public static final String channel_page_url = "http://wcms-www.test.abc.net.au/test-triplej/programs/hack/";
	// public static final String channel_page_url =
	// "http://10.25.126.162:8001/wcms/servlet/page/hack-poc/";
	// index page url
	public static final String index_page_url = "http://wcms-www.test.abc.net.au/test-triplej/programs/hack/drugs/";

	// article page url
	public static final String article_page_url = "http://wcms-www.test.abc.net.au/test-triplej/programs/hack/drug-driving:-there-is-no-minimum-level-behind-the-wheel/200194626";

	// commonTest.java file
	// w3cvalidator url id
	public static final String validatorUrl = "uri";

	// w3c validator result xpath
	public static final String validatorresult = ".//*[@id='form']/table/tbody/tr[1]/td";

	// w3c validator link
	public static final String w3cValidatorLink = "https://validator.w3.org/";

	// w3c link checker url
	public static final String w3cLinkChecker = "https://validator.w3.org/checklink";

	// w3c link checker url field id
	public static final String w3cLinkCheckerUrl = "uri_1";

	// w3c link checker done status field
	public static final String w3cLinkCheckerDone = "//*[@id='progressresults1']/h3/span";

	// w3c link checker results link text
	public static final String w3cLinkCheckerResults = "the results";

	// w3c link checker results table xpath
	public static final String w3cLinkCheckerResultsTable = "//*[@id='main']/table[1]";

	// more menu item xpath
	// public static final String more =
	// "//*[@id='navigationPrimary2']/nav/ul/li[18]/a";
	public static final String more = ".more-link.js-toggle-primary-nav";
	// world menu item xpath
	public static final String world_menuitem = ".//*[@id='navigationPrimary2']/nav/ul/li[17]/ul/li[16]/span";

	// menuitems id
	public static final String topMenuItems = "navigationPrimary2";

	// index page title text xpath
	public static final String indexPageTitleText = "//*[@class='view-collection-grid-fixed']/h2";

	// article images xpath
	public static final String articleImages = "//*[contains(@id,'comp-paginate')]";

	// article metatags xpath
	public static final String articleMetaTags = "//meta[@property='article:tag']";

	// channel page items
	// Email hack button
	public static final String emailHack = "//*[contains(@id,'contact-form')]/div/button";

	// contact form name name
	public static final String name = "realname";

	// contact form email name
	public static final String email = "email";

	// contact form subject name
	public static final String subject = "subject";

	// contact form message name
	public static final String message = "comments";

	// Send Email button
	public static final String sendEmail = "submit";

	// name error
	public static final String nameError = "namecontact-form8-error";

	// email error
	public static final String emailError = "emailcontact-form8-error";

	// subject error
	public static final String subjectError = "subjectcontact-form8-error";

	// message error
	public static final String messageError = "messagecontact-form8-error";

	// name error message
	public static final String nameErrorMessage = "Please enter your name";

	// email error Message
	public static final String emailErrorMessage = "An email address is required";

	// subject error Message
	public static final String subjectErrorMessage = "Please enter a subject";

	// message error Message
	public static final String messageErrorMessage = "Please enter your message";

	// carousel next button xpath
	// public static final String carousel_nextbtn =
	// "//*[@id='collection-slick-carousel4']/button[2]";
	public static final String carousel_nextbtn = "//*[contains(@id,'collection-slick-carousel')]/button[2]";
	// carousel list item to get the class name
	// public static final String carousel_listitem1 =
	// "//*[@id='collection-slick-carousel4']/ul/li[1]";
	public static final String carousel_listitem1 = "//*[contains(@id,'collection-slick-carousel')]/ul/li[1]";

	// carousel image
	// public static final String carousel_image =
	// "//span[starts-with(@id,'CTX')]/a/div[1]/img";
	// public static final String carousel_image = "//div[@class =
	// 'view-slick-carousel-item']/span/a/div[1]/img";
	// public static final String carousel_image =
	// "//*[@id='collection-slick-carousel4']/div/div/div[4]/div/a/div[1]/img";
	public static final String carousel_image = "//*[contains(@id,'collection-slick-carousel')]/div/div/div[3]/div/a/div[1]/img";

	// article page
	public static final String facebookCommentsUrl = "http://wcms-www.test.abc.net.au/test-triplej/programs/hack/drug-driving:-there-is-no-minimum-level-behind-the-wheel/200194626";

	// facebook comments box xpath
	// public static final String facebook_commentsBox = "//*[@title = 'Add a
	// comment...']";
	public static final String facebook_commentsBox = "//*[@title='Add a comment...']";

	// facebook comments post button xpath
	public static final String facebook_postBtn = "//*[@type = 'submit']";

	// facebook comments text message
	public static final String facebook_commentsTextMsg = "test comment";

	// gmail user name
	public static final String gmail_userName = "testabc641@gmail.com";

	// gmail password
	public static final String gmail_password = "test@abc";

	// facebook login button name
	public static final String facebook_loginBtn = "login";

	// facebook comments text
	public static final String facebook_commentsText = "//*[@id='u_0_0']/div/div/div[3]/div/div[2]/div/div[2]/div/div[1]/div/span[1]/span/span";

	// facebook page email id
	public static final String facebook_id = "email";

	// facebook page password
	public static final String facebook_password = "pass";

	// post comments on to facebook checkbox
	public static final String facebook_menu = "//*[contains(@id,'js_*')]";

	// facebook post checkbox
	public static final String facebook_post_checkbox = "//*[@type='checkbox']";

	// facebook home profile(eg:click on Tom Reddy)
	public static final String facebook_home_profile = "//*[@id='pagelet_welcome_box']/ul/li[1]/div/div/a";

	// facebook post text from facebook page
	public static final String facebook_post_fbpage = "//*[contains(@id,'js')]/p";

	// article page url containing youtube video in first iframe
	public static final String youTubeUrl = "http://wcms-www.test.abc.net.au/test-triplej/programs/hack/university-fees-deregulation-wont-hapopen-next-year/200217174";

	// article page url containing youtube playlist in first iframe
	public static final String youTubePlayListUrl = "http://wcms-www.test.abc.net.au/test-triplej/programs/hack/bacon/200192410";

	// you tube play button xpath
	// public static final String youTubePlayBtn = "//*[@class =
	// 'ytp-large-play-button ytp-button']";
	public static final String youTubePlayBtn = ".ytp-large-play-button.ytp-button";

	public static final String soundCloudUrl = "http://wcms-www.test.abc.net.au/test-triplej/programs/hack/200194626";

	// All index page title
	public static final String AllIndexTitle = "Hack | triple j";

	// triplej icon cssselector class name
	public static final String triplejIcon = ".social-icon.social-channels-triplej.list-item-icon.icon-triplej";

	// facebook icon cssselector class name
	public static final String facebookIcon = ".social-icon.social-channels-facebook.list-item-icon.icon-facebook";

	// twitter icon cssselector class name
	public static final String twitterIcon = ".social-icon.social-channels-twitter.list-item-icon.icon-twitter";

	// instagram icon cssselector class name
	public static final String InstagramIcon = ".social-icon.social-channels-instagram.list-item-icon.icon-instagram";

	// youtube icon cssselector class name
	public static final String youTubeIcon = ".social-icon.social-channels-youtube.list-item-icon.icon-youtube";

	// soundcloud icon cssselector class name
	public static final String soundCloudIcon = ".social-icon.social-channels-soundcloud.list-item-icon.icon-soundcloud";

	// triplej icon cssselector class name
	public static final String triplejRedirectUrl = "http://www.abc.net.au/triplej/";

	// facebook icon cssselector class name
	public static final String facebookRedirectUrl = "https://m.facebook.com/triplejHack";

	// twitter icon cssselector class name
	public static final String twitterRedirectUrl = "https://mobile.twitter.com/triplejHack";

	// instagram icon cssselector class name
	public static final String InstagramRedirectUrl = "https://instagram.com/triplejhack/";

	// youtube icon cssselector class name
	public static final String youTubeRedirectUrl = "https://m.youtube.com/channel/UCd2KNtfphz8HvYzM4pwtHmg";

	// soundcloud icon cssselector class name
	public static final String soundCloudRedirectUrl = "https://m.soundcloud.com/triple-j-hack";

	// topics class
	public static final String topics = "/html/body/div[3]/a/span";

	// topics menu items
	public static final String topicsMenuItems = ".more-menu.more-level-1.wcms-mobile-nav-fixed.mobile-nav-animate";
}
