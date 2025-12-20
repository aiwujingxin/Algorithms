package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/9/25 16:31
 */
public class LeetCode1191 {
    int mod = 1_000_000_007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        if (k == 1) {
            return (int) maxSubArray(arr);
        }
        long sum = 0;
        int[] nums = new int[n * 2];
        for (int i = 0; i < n; i++) {
            sum = (sum + arr[i]) % mod;
            for (int j = 0; j < 2; j++) {
                nums[i + j * n] = arr[i];
            }
        }
        if (sum > 0) {
            return (int) (sum * k % mod);
        }
        long max2 = maxSubArray(nums);
        if (k == 2) {
            return (int) max2;
        }
        return (int) (max2 + sum * (k - 2) % mod) % mod;
    }

    public long maxSubArray(int[] nums) {
        long pre = 0, max = nums[0];
        for (int x : nums) {
            pre = Math.max((pre + x) % mod, x);
            max = Math.max(max, pre);
        }
        return Math.max(max, 0);
    }
}
