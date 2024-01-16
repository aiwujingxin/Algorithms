package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 22:31
 */
public class LeetCode930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        if (goal == 0) {
            return getSubArr(nums, 0);
        }
        return getSubArr(nums, goal) - getSubArr(nums, goal - 1);
    }

    private int getSubArr(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int res = 0;
        while (right < n) {
            cnt += nums[right];
            while (cnt > k) {
                cnt -= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
