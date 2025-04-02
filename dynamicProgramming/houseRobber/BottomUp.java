package dynamicProgramming.houseRobber;

public class BottomUp {
    
    public static void main(String[] args) {
		int[] HouseNetWorth = { 6, 7, 1, 30, 8, 2, 4 };
		System.out.println("Max Money: " + maxMoneyBottomUp(HouseNetWorth));
	}

    public static int maxMoneyBottomUp(int[] wealth) {
		int dp[] = new int[wealth.length + 2]; // '+1' to handle the zero house
		dp[wealth.length] = 0; // if there are no houses, the thief can't steal anything
		for (int i = wealth.length - 1; i >= 0; i--) {
			dp[i] = Math.max(wealth[i] + dp[i + 2], dp[i + 1]);
		}
		return dp[0];
	}
}
