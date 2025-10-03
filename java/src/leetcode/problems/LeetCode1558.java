package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:23
 */
public class LeetCode1558 {

    public int minOperations(int[] nums) {
        int ans = 0;
        int max = 0;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
            ans += Integer.bitCount(i);
        }
        if (max == 0) {
            return 0;
        }
        return ans + 31 - Integer.numberOfLeadingZeros(max);
    }
}
