package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 15:11
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                res = nums[i];
                cnt = 0;
            }
        }
        return res;
    }
}
