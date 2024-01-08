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
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + code[i - 1];
        }
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                if (i + k < n) {
                    code[i] = presum[i + k + 1] - presum[i + 1];
                } else {
                    code[i] = (presum[n] - presum[i + 1]) + presum[k - (n - i) + 1];
                }
            }
        }
        if (k < 0) {
            k = -k;
            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    code[i] = presum[i] - presum[i - k];
                } else {
                    code[i] = presum[i] + (presum[n] - presum[n - (k - i)]);
                }
            }
        }
        return code;
    }
}
