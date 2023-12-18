package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 14:21
 */
public class LeetCode169 {

    //摩尔投票法：摩尔投票法的核心思想为对拼消耗。
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == res) {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0) {
                    res = nums[i];
                    cnt = 1;
                }
            }
        }
        return res;
    }
}
