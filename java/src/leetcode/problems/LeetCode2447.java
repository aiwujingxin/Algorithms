package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 11:34
 */
public class LeetCode2447 {

    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int d = nums[i];
            for (int j = i; j < n && d >= k; j++) {
                d = gcd(d, nums[j]);
                if (d == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
