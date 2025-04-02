public class NumberFactor {
  public static void main(String[] args) {
    int n = 5;
    System.out.println("Number of ways to get " + n + " is: " + waysToGetN(n));
    n = 6;
    System.out.println("Number of ways to get " + n + " is: " + waysToGetN(n));
    n = 7;
    System.out.println("Number of ways to get " + n + " is: " + waysToGetN(n));
    n = 8;
    System.out.println("Number of ways to get " + n + " is: " + waysToGetN(n));
    n = 9;
    System.out.println("Number of ways to get " + n + " is: " + waysToGetN(n));
  }

  /**
   * This method calculates the number of ways to get a number n using 1, 3, and 4.
   * 
   * @param n the number to get
   * @return the number of ways to get n
   */
  public static int waysToGetN(int n) {
    if ((n==0) || (n==1) || (n==2)) {
      return 1;
    }
    if (n == 3) {
      return 2; //{1,1,1} {3}
    }
    int sub1 = waysToGetN(n-1);
    int sub2 = waysToGetN(n-3);
    int sub3 = waysToGetN(n-4);

    return sub1+sub2+sub3;

  }
}
