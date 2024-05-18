public class SortedMatrices {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 50 }
        };
        System.out.println(Arrays.toString(search(arr, 16)));
    }

    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[] { row, mid };
            } else if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return new int[] { -1, -1 };
    }

    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }
        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;
        // Search possible row where the target is located
        while (rStart < rEnd) {
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] <= target) {
                rStart = mid;
            } else {
                rEnd = mid - 1;
            }
        }
        // Search in the identified row
        int[] ans = binarySearch(matrix, rStart, 0, cols - 1, target);
        if (ans[0] != -1) {
            return ans;
        }
        return new int[] { -1, -1 };
    }
}