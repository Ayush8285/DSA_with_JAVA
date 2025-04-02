package dynamicProgramming.numberFactor;

public class BottomUp {
    public static void main(String[] args) {
        System.out.println(waysToGetNBottomUp(5)); // Output: 3
    }
    

    public static int waysToGetNBottomUp(int n) {
        int dp[] = new int[n+1];
        dp[0]=dp[1]=dp[2]=1;
        dp[3] = 2;
        for (int i = 4; i<=n; i++) {
          dp[i] = dp[i-1]+dp[i-3]+dp[i-4];
        }
        return dp[n];
      }
}
