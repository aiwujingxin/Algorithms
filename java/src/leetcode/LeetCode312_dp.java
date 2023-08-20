package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 23:24
 */
public class LeetCode312_dp {

    //https://www.youtube.com/watch?v=Ci39lcoLbyw
    //https://leetcode.com/problems/burst-balloons/discuss/2416976/Memoization-oror-Tabulation-oror-PartitionDP-oror-Java
    public int maxCoins(int[] nums) {
        // init
        int N = nums.length;
        int[] arr = new int[N + 2];
        arr[0] = 1;
        arr[N + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, N);
        int[][] dp = new int[N + 2][N + 2];
        for (int i = N; i >= 1; i--) {
            for (int j = 1; j <= N; j++) {
                if (i > j) {
                    continue;
                }
                int maxi = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int coins = arr[i - 1] * arr[k] * arr[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                    maxi = Math.max(maxi, coins);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][N];
    }
}
