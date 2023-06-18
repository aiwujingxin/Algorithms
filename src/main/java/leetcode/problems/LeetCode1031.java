package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/14 17:59
 */
public class LeetCode1031 {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        return Math.max(f(s, firstLen, secondLen), f(s, secondLen, firstLen));
    }

    private int f(int[] s, int firstLen, int secondLen) {
        int maxSumA = 0, res = 0;
        for (int i = firstLen + secondLen; i < s.length; ++i) {
            maxSumA = Math.max(maxSumA, s[i - secondLen] - s[i - secondLen - firstLen]);
            res = Math.max(res, maxSumA + s[i] - s[i - secondLen]);
        }
        return res;
    }
}
