public class NumberOfPathsToReachLastCell {
  public static void main(String[] args) {
    int array[][] = {
      {1, 1, 3},
      {4, 5, 1},
      {7, 8, 9}
    };
    int cost = 15;
    System.out.println("Number of paths to reach last cell with cost " + cost + " is: " + numberOfPaths(array, array.length-1, array[0].length-1, cost));
    cost = 10;
    System.out.println("Number of paths to reach last cell with cost " + cost + " is: " + numberOfPaths(array, array.length-1, array[0].length-1, cost));
  }
  public static int numberOfPaths(int array[][], int row, int col, int cost) {
    if (cost < 0) {
      return 0;
    }

    if (row == 0 && col == 0) {
      return (array[0][0]-cost==0)? 1 : 0;
    }

    if (row == 0) {
      return numberOfPaths(array, 0, col-1, cost-array[row][col]);
    }

    if (col == 0 ) {
      return numberOfPaths(array, row-1, 0, cost-array[row][col]);
    }

    int noOfPathsFromPreviousRow = numberOfPaths(array, row-1, col, cost-array[row][col]);
    int noOfPathsFromPreviousCol = numberOfPaths(array, row, col-1, cost-array[row][col]);

    return noOfPathsFromPreviousRow + noOfPathsFromPreviousCol;

  }
}
