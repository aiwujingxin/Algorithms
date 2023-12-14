package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/14 22:03
 */
public class LeetCode137 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int t = 0;
            for (int n : nums) {
                t += (n >> i) & 1;//得到 num 的第 i 个二进制位
            }
            if (t % 3 != 0) { //属于res的位
                res |= 1 << i;
            }
        }
        return res;
    }
}
