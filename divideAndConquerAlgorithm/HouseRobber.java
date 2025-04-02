public class HouseRobber {

  public static void main(String[] args) {
    int[] HouseNetWorth = {2, 7, 9, 3, 1};
    System.out.println("Maximum money that can be robbed: " + maxMoney(HouseNetWorth));
    HouseNetWorth = new int[]{1, 2, 3, 1};
    System.out.println("Maximum money that can be robbed: " + maxMoney(HouseNetWorth));
    HouseNetWorth = new int[]{2, 1, 1, 2};
    System.out.println("Maximum money that can be robbed: " + maxMoney(HouseNetWorth));
  }

  private static int maxMoneyRecursive(int[] HouseNetWorth, int currentIndex) {
    if (currentIndex >= HouseNetWorth.length) {
      return 0;
    }

    int stealCurrentHouse = HouseNetWorth[currentIndex] + maxMoneyRecursive(HouseNetWorth, currentIndex+2);
    int skipCurrentHouse = maxMoneyRecursive(HouseNetWorth, currentIndex+1);

    return Math.max(stealCurrentHouse,skipCurrentHouse );
  }

  public static int maxMoney(int[] HouseNetWorth) {
    return maxMoneyRecursive(HouseNetWorth, 0);
  }
}
