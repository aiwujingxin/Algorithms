package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/8 14:45
 */
public class LeetCode1652 {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + code[i - 1];
        }
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                if (i + k < n) {
                    code[i] = sum[i + k + 1] - sum[i + 1];
                } else {
                    code[i] = (sum[n] - sum[i + 1]) + sum[k - (n - i) + 1];
                }
            }
        }
        if (k < 0) {
            k = -k;
            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    code[i] = sum[i] - sum[i - k];
                } else {
                    code[i] = sum[i] + (sum[n] - sum[n - (k - i)]);
                }
            }
        }
        return code;
    }
}
