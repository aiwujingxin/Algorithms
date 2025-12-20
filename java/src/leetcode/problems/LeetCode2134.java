package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/11/25 22:04
 */
public class LeetCode2134 {

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n * 2];
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            cnt1 += nums[i];
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }
        int[] pre = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, cnt1 - (pre[i + cnt1 - 1 + 1] - pre[i]));
        }
        return min;
    }
}
