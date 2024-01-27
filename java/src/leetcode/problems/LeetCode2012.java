package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/26 18:26
 */
public class LeetCode2012 {

    public int sumOfBeauties(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftMax = nums[0];
        left[0] = leftMax;
        for (int i = 1; i < n; i++) {
            left[i] = leftMax;
            if (nums[i] > leftMax) {
                leftMax = nums[i];
            }
        }
        int rightMin = nums[n - 1];
        right[n - 1] = rightMin;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = rightMin;
            if (nums[i] < rightMin) {
                rightMin = nums[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] < nums[i] && right[i] > nums[i]) {
                sum += 2;
            } else if ((i > 0 && i < n - 1) && (nums[i - 1] < nums[i] && nums[i] < nums[i + 1])) {
                sum += 1;
            }
        }
        return sum;
    }
}
