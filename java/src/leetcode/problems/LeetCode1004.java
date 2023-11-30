package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/31 23:45
 */
public class LeetCode1004 {

    public int longestOnes(int[] nums, int k) {
        int N = nums.length;
        int res = 0;
        int left = 0, right = 0;
        int count = 0;
        while (right < N) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
