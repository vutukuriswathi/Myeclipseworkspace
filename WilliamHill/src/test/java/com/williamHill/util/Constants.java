package com.williamHill.util;

public class Constants {

	// PATHS
	public static final String Config_File_Path = System.getProperty("user.dir")
			+ "//src//test//java//com//williamHill//config//config.properties";

	public static final String williamHillSite = "https://www.williamhill.com.au";

	// HomePage elements

	// nextToJump element
	public static final String nextToJump = ".item.is-active";

	// race lists element
	public static final String raceLists = "item";

	// runner list horses
	public static final String runnerListHorses = "runner-list";

	// 3rd horse from the first column
	public static final String InterestedHorse = "//*[@id='js-bet-block-racing']/div/div[1]/div/div[2]/div[3]/button";

	// betslip badge
	public static final String betSlipBadge = "betslipBadge";

	// betslip badge count
	public static final String betSlipBadgeCount = "1";

	// stake
	public static final String stake = "UnitStake-1";

	// stake amount
	public static final String stakeAmount = "10.5";

	// No:of bets
	public static final String totalBets = "bs_total_bets";

	// Total stake
	public static final String totalStake = "bs_total_stake";

	// Expected stake
	public static final String expectedStake = "$10.50";

	// Expected no:of Bets
	public static final String expectedBets = "1";

	// possible payout
	public static final String possiblePayout = "bs_total_payout";

}
