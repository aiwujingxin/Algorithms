package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 11:54
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{};
        }
        int flag = 0;
        int[] t = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + flag + (i == digits.length - 1 ? 1 : 0);
            flag = sum / 10;
            t[i] = sum % 10;
        }
        if (flag == 0) {
            return t;
        }
        int[] res = new int[t.length + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = t[i - 1];
        }
        return res;
    }
}
