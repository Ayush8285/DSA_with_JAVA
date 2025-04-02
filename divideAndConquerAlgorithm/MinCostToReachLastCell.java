public class MinCostToReachLastCell {

  public static void main(String[] args) {
    int[][] cost = {
      {1, 2, 3},
      {4, 8, 2},
      {1, 5, 3}
    };
    int row = cost.length - 1;
    int col = cost[0].length - 1;
    System.out.println("Minimum cost to reach last cell: " + findMinCost(cost, row, col));
  }

  //Diagonally not allowed

  public static int findMinCost(int[][] cost, int row, int col) {
    if (row == -1 || col == -1 ) {
      return Integer.MAX_VALUE;
    }
    if (row == 0 && col == 0) {
      return cost[0][0];
    }
    int minCost1 = findMinCost(cost, row, col-1);
    int minCost2 = findMinCost(cost, row-1, col);
    int minCost = Integer.min(minCost1, minCost2);
    return minCost + cost[row][col];
  }
}
