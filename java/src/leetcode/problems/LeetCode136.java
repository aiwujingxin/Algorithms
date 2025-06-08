package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 11:31
 */
public class LeetCode136 {

    public int singleNumber(int[] nums) {
        int res = 0; // 从0开始异或更合理
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
