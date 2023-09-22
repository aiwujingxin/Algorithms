package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 22:50
 */
public class LeetCode312_dfs_memo {


    //https://leetcode.com/problems/burst-balloons/discuss/2416976/Memoization-oror-Tabulation-oror-PartitionDP-oror-Java

    int[][] memo;
    int[] arr;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        memo = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return findCoin(1, n);
    }

    int findCoin(int i, int j) {
        //base case
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int maxi = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int coins = arr[i - 1] * arr[k] * arr[j + 1] + findCoin(i, k - 1) + findCoin(k + 1, j);
            maxi = Math.max(maxi, coins);
        }
        memo[i][j] = maxi;
        return memo[i][j];
    }
}

