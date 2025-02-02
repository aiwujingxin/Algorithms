package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 1/11/25 13:46
 */
public class LeetCode3334 {

    public long maxScore(int[] nums) {
        int n = nums.length;
        int[] sufGcd = new int[n + 1];
        long[] sufLcm = new long[n + 1];
        sufLcm[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            sufGcd[i] = (int) gcd(sufGcd[i + 1], nums[i]);
            sufLcm[i] = lcm(sufLcm[i + 1], nums[i]);
        }

        long ans = sufGcd[0] * sufLcm[0];
        int preGcd = 0;
        long preLcm = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, gcd(preGcd, sufGcd[i + 1]) * lcm(preLcm, sufLcm[i + 1]));
            preGcd = (int) gcd(preGcd, nums[i]);
            preLcm = lcm(preLcm, nums[i]);
        }
        return ans;
    }

    private long gcd(long a, long b) {
        while (a != 0) {
            long tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
