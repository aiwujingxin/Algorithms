package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 02:13
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] a = new int[n + 1];
        a[0] = 1;
        return a;
    }
}
