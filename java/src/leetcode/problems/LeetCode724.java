package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 14:02
 */
public class LeetCode724 {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            presum[i] = presum[i + 1] + nums[i];
        }
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (t == presum[i + 1]) {
                return i;
            }
            t += nums[i];
        }
        return -1;
    }
}
