package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 15:11
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        int res = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            cnt += nums[i] == res ? 1 : -1;
            if (cnt == 0) {
                res = nums[i];
                cnt = 1;
            }
        }
        return res;
    }
}
