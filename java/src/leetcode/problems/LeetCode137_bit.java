package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 12:20
 */
public class LeetCode137_bit {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                // 对于数组中的每一个元素 num，我们使用位运算 (num >> i) & 1得到 num 的第 i 个二进制位
                // 并将它们相加再对 3 取余，得到的结果一定为 0 或 1，即为答案的第 i 个二进制位。
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
