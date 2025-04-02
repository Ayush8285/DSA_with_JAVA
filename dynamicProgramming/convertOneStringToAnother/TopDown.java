package dynamicProgramming.convertOneStringToAnother;

public class TopDown {

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        System.out.println("Minimum operations required to convert " + s1 + " to " + s2 + " is: " + findMinOperationsTD(s1, s2));
    }


    public static int findMinOperationsTD(String s1, String s2) {
	    Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
	    return findMinOperationsTD(dp, s1, s2, 0, 0);
	  }//end of method
 
	  private static int findMinOperationsTD(Integer[][] dp, String s1, String s2, int i1, int i2) {
	    if(dp[i1][i2] == null) { 
	      if(i1 == s1.length()) // if we have reached the end of s1, then insert all the remaining characters of s2
	        dp[i1][i2] = s2.length() - i2;
	     
	      else if(i2 == s2.length()) // if we have reached the end of s2, then delete all the remaining characters of s1
	        dp[i1][i2] = s1.length() - i1;
	      
	      else if(s1.charAt(i1) == s2.charAt(i2)) // If the strings have a matching character, recursively match for the remaining lengths.
	        dp[i1][i2] = findMinOperationsTD(dp, s1, s2, i1+1, i2+1);
	  
	      else {
	        int c1 = findMinOperationsTD(dp, s1, s2, i1+1, i2); //delete
	        int c2 = findMinOperationsTD(dp, s1, s2, i1, i2+1); //insert
	        int c3 = findMinOperationsTD(dp, s1, s2, i1+1, i2+1); //replace
	        dp[i1][i2] = 1 + Math.min(c1, Math.min(c2, c3));
	      }
	    }//end of if-else
	    return dp[i1][i2];
	  }//end of method
    
}
