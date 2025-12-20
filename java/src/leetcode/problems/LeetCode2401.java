package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/16/25 13:08
 */
public class LeetCode2401 {

    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][32];
        for (int i = 0; i < n; i++) {
            arr[i] = cal(nums[i]);
        }
        int[][] presum = new int[n + 1][32];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 32; j++) {
                presum[i][j] = presum[i - 1][j] + arr[i - 1][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 在 [i, n-1] 范围内查找满足 check 条件的最大的下标
            int bestJ = findR(presum, i, n);
            ans = Math.max(ans, bestJ - i + 1);
        }
        return ans;
    }

    private int findR(int[][] presum, int leftIndex, int n) {
        int l = leftIndex;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (check(presum, leftIndex, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[][] presum, int left, int right) {
        for (int k = 0; k < 32; k++) {
            if (presum[right + 1][k] - presum[left][k] > 1) {
                return false;
            }
        }
        return true;
    }

    private int[] cal(int num) {
        int[] a = new int[32];
        for (int i = 0; i < 32; i++) {
            a[i] = (num >> i) & 1;
        }
        return a;
    }
}
