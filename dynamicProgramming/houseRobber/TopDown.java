package dynamicProgramming.houseRobber;

public class TopDown {
	public static void main(String[] args) {
		int[] HouseNetWorth = { 6, 7, 1, 30, 8, 2, 4 };
		System.out.println("Max Money: " + maxMoneyTopDown(HouseNetWorth));
	}
 
	public static int maxMoneyTopDown(int[] HouseNetWorth) {
		int dp[] = new int[HouseNetWorth.length];
		return maxMoneyTopDown(dp, HouseNetWorth, 0);
	}
 
 
	private static int maxMoneyTopDown(int[] dp, int[] HouseNetWorth, int currentIndex) {
		if (currentIndex >= HouseNetWorth.length)
			return 0;
 
		if (dp[currentIndex] == 0) {
			int stealCurrent = HouseNetWorth[currentIndex] + maxMoneyTopDown(dp, HouseNetWorth, currentIndex + 2);
			int skipCurrent = maxMoneyTopDown(dp, HouseNetWorth, currentIndex + 1);
			dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
		}
		return dp[currentIndex];
	}
}
