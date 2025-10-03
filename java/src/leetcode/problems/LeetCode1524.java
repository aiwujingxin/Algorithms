package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/7 10:56
 */
public class LeetCode1524 {

    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + arr[i - 1];
        }
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        long res = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] % 2 == 1) {
                res = (res + map.getOrDefault(0, 0L)) % mod;
            } else {
                res = (res + map.getOrDefault(1, 0L)) % mod;
            }
            map.put(s[i] % 2, map.getOrDefault(s[i] % 2, 0L) + 1);
        }
        return (int) (res % mod);
    }
}
