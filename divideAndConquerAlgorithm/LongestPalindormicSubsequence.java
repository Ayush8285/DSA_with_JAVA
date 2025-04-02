public class LongestPalindormicSubsequence {

  public static void main(String[] args) {
    String st = "abdbca";
    System.out.println("Length of LPS is: " + findLPSLength(st));
    st = "cddpd";
    System.out.println("Length of LPS is: " + findLPSLength(st));
    st = "pqr";
    System.out.println("Length of LPS is: " + findLPSLength(st));
  }
  private static int findLPSLength(String st, int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      return 0;
    }
    if (startIndex == endIndex) {
      return 1;
    }

    int count1 = 0;
    if (st.charAt(startIndex) == st.charAt(endIndex)) {
      count1 = 2 + findLPSLength(st, startIndex+1, endIndex-1);
    }
    int count2 = findLPSLength(st, startIndex+1, endIndex);
    int count3 = findLPSLength(st, startIndex, endIndex-1);

    return Math.max(count1, Math.max(count2, count3));
  }

  public static int findLPSLength(String st) {
    return findLPSLength(st, 0, st.length()-1);
  }
}
