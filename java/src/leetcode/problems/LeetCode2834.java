package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/2 22:19
 */
public class LeetCode2834 {

    public int minimumPossibleSum(int n, int target) {
        int mod = 1000000007;
        if (target > 2 * n || target <= 2) {
            return (int) ((1 + (long) n) * n / 2 % mod);
        }
        long minusCount = target % 2 == 0 ? target / 2 - 1 : target / 2;
        long max = n + minusCount;
        long sum = ((1 + max) * max / 2 - (target / 2 + 1 + target / 2 + minusCount) * minusCount / 2) % mod;
        return (int) (sum);
    }
}
