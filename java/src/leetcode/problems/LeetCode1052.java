package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/18 11:44
 */
public class LeetCode1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int l = 0;
        int r = 0;
        int n = customers.length;
        while (right < n) {
            sum += grumpy[right] == 1 ? customers[right] : 0;
            while (right - left + 1 > minutes) {
                sum -= grumpy[left] == 1 ? customers[left] : 0;
                left++;
            }
            if (right - left + 1 == minutes) {
                if (sum > max) {
                    max = sum;
                    l = left;
                    r = right;
                }
            }
            right++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i >= l && i <= r) {
                res += customers[i];
            } else {
                res += grumpy[i] == 0 ? customers[i] : 0;
            }
        }
        return res;
    }
}
