public class ZeroOneKnapsack {
  public static void main(String[] args) {
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int capacity = 7;
    System.out.println("Maximum profit is: " + knapSack(profits, weights, capacity));
    capacity = 6;
    System.out.println("Maximum profit is: " + knapSack(profits, weights, capacity));
    capacity = 5;
    System.out.println("Maximum profit is: " + knapSack(profits, weights, capacity));
    capacity = 4;
    System.out.println("Maximum profit is: " + knapSack(profits, weights, capacity));
  }
 private static int knapSack(int[] profits, int[] weights, int capacity, int currentIndex) {
   if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) {
     return 0;
   }
   int profit1 = 0;
   if (weights[currentIndex] <= capacity) {
     profit1 = profits[currentIndex] + knapSack(profits, weights, capacity-weights[currentIndex], currentIndex+1);
   }
   int profit2 = knapSack(profits, weights, capacity, currentIndex+1);
   return Math.max(profit1, profit2);
 }

 public static int knapSack(int[] profits, int[] weights, int capacity) {
   return knapSack(profits, weights,  capacity, 0);
 }
}
