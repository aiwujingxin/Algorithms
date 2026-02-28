package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:03
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
