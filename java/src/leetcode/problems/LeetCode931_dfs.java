package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 00:49
 */
public class LeetCode931_dfs {
    //https://leetcode.com/problems/minimum-falling-path-sum/discuss/935121/JAVA-Recursion-With-Memorization
    public int minFallingPathSum(int[][] A) {
        int[][] memo = new int[A.length][A[0].length];

        // In the first row, we can start at any element
        // Find the min path
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < A[0].length; j++) {
            ans = Math.min(ans, dp(A, 0, j, memo));
        }

        return ans;
    }

    // Defination: Falling from the first row, find the shortest path to reach the last row
    private int dp(int[][] A, int i, int j, int[][] memo) {
        // Base case
        // 1. No more row to falling
        if (i >= A.length) {
            return 0;
        }

        // 2. Invalid column index
        if (j < 0 || j >= A[0].length) {
            return Integer.MAX_VALUE;
        }

        // 3. If we are already solved it, return the result
        if (memo[i][j] != 0) {
            return memo[i][j];
        }


        // Make choice
        // We have three choices to falling whitch is from the left(j - 1), center(j) or right(j + 1)
        return memo[i][j] = A[i][j] + min(dp(A, i + 1, j - 1, memo),
                dp(A, i + 1, j + 1, memo),
                dp(A, i + 1, j, memo));
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
