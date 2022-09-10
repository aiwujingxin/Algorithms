package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/17 15:14
 */
public class LeetCode1278_Recursion {

    //https://leetcode.com/problems/palindrome-partitioning-iii/discuss/441513/Java-Simple-Recursion-and-Memoization


    public static void main(String[] args) {
        System.out.println(new LeetCode1278_Recursion().palindromePartition("aabbc", 3));
    }

    public static int divide(String s, int[][][] dp, int k, int start, int end) {

        if (dp[start][end][k] != -1) {
            return dp[start][end][k];
        }

        if (k == 1) {
            return dp[start][end][k] = change(s, start, end);
        }

        if (start == end) {
            if (k <= 1) {
                return dp[start][end][k] = k;
            }
            //无解
            return dp[start][end][k] = Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            int x1 = divide(s, dp, 1, start, i);
            int x2 = divide(s, dp, k - 1, i + 1, end);
            if (x1 != Integer.MAX_VALUE && x2 != Integer.MAX_VALUE) {
                min = Math.min(x1 + x2, min);
            }
        }

        return dp[start][end][k] = min;
    }

    public static int change(String s, int start, int end) {
        int count = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                count++;
            }
            start++;
            end--;
        }
        return count;
    }

    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][][] dp = new int[n][n][k + 1];

        //init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < k + 1; p++) {
                    dp[i][j][p] = -1;
                }
            }
        }
        return divide(s, dp, k, 0, n - 1);
    }
}
