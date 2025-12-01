package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 11/20/25 16:07
 */
public class LeetCode1814 {

    public int countNicePairs(int[] nums) {
        int mod = 1_000_000_007;
        long ans = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            int t = num - rev(num);
            long cnt = map.merge(t, 1L, Long::sum);
            ans = (ans + (cnt - 1) % mod) % mod;
        }
        return (int) ans;
    }

    private int rev(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }
}
