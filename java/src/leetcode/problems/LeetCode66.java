package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:03
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int flag = 0;
        digits[n - 1]++;
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + flag;
            flag = sum / 10;
            digits[i] = sum % 10;
        }
        if (flag == 1) {
            int[] res = new int[n + 1];
            res[0] = 1;
            for (int i = 1; i <= n; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }
}
