package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 22:50
 */
public class LeetCode312_dfs {

    //https://leetcode.com/problems/burst-balloons/discuss/2416976/Memoization-oror-Tabulation-oror-PartitionDP-oror-Java
    public int maxCoins(int[] nums) {
        //init
        int N = nums.length;
        int[] arr = new int[N + 2];
        arr[0] = 1;
        arr[N + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, N);
        //momo
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return findCoin(1, N, arr, dp);
    }

    int findCoin(int i, int j, int[] arr, int[][] dp) {
        if (i > j) {
            return 0;
        }
        //base case
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int maxi = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int coins = arr[i - 1] * arr[k] * arr[j + 1] +
                    findCoin(i, k - 1, arr, dp) +
                    findCoin(k + 1, j, arr, dp);
            maxi = Math.max(maxi, coins);
        }
        dp[i][j] = maxi;
        return dp[i][j];
    }
}

