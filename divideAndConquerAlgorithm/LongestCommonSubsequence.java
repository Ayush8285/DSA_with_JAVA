public class LongestCommonSubsequence {

  public static void main(String[] args) {
    String s1 = "AGGTAB";
    String s2 = "GXTXAYB";
    System.out.println("Length of LCS is: " + findLCSLength(s1, s2));
    s1 = "ABCBDAB";
    s2 = "BDCAB";
    System.out.println("Length of LCS is: " + findLCSLength(s1, s2));
    s1 = "ABCDEF";
    s2 = "FBDAMN";
    System.out.println("Length of LCS is: " + findLCSLength(s1, s2));
  }

  private static int findLCSLength(String s1, String s2, int i1, int i2) {
    if (i1 == s1.length() || i2 == s2.length()) {
      return 0;
    }
    int c1 = 0;
    if (s1.charAt(i1) == s2.charAt(i2)) {
      c1 = 1 + findLCSLength(s1, s2, i1+1, i2+1);
    }
    int c2 = findLCSLength(s1, s2, i1, i2+1);
    int c3 = findLCSLength(s1, s2, i1+1, i2);
    return Math.max(c1, Math.max(c2, c3));
  }

  public static int findLCSLength(String s1, String s2) {
    return findLCSLength(s1, s2, 0, 0);
  }
}
