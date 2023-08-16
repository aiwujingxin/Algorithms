package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 18:47
 */
public class LeetCode1658 {

    public int minOperations(int[] nums, int x) {
        // 求最长连续子数组，使得其和为sum(nums)-x
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        int target = s - x;
        if (target < 0) {
            return -1;
        }

        int n = nums.length;
        int left = 0;   // [left, right]: 滑动窗口左右端点
        int right = 0;
        int len = -1;   // 和为target的连续子数组的长度
        int sum = 0;  // 滑动窗口中的数字总和
        while (right < n) {
            sum += nums[right];   // 新加入窗口中的元素
            while (sum > target) {
                sum -= nums[left]; // 滑出窗口中的元素
                left++;
            }

            if (sum == target) {
                len = Math.max(len, right - left + 1);
            }

            right++;
        }

        return len == -1 ? -1 : n - len;
    }
}
