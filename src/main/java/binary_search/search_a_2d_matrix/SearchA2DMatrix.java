package binary_search.search_a_2d_matrix;

// leetcode-74: Search a 2D Matrix
public class SearchA2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length - 1;
    int n = matrix[0].length - 1;

    int low = 0;
    int high = m;
    int row = -1;

    while (low < high) {
      int mid = low + (high - low) / 2;
      if (target < matrix[mid][0]) {
        high = mid - 1;
      } else if (target > matrix[mid][n]) {
        low = mid + 1;
      } else {
        row = mid;
        break;
      }
    }
    if (low > high) {
      return false;
    }
    if (row == -1) {
      row = low;
    }
    low = 0;
    high = n;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (matrix[row][mid] == target) {
        return true;
      } else if (target < matrix[row][mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }
}
