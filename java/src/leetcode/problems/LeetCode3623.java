package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 12/2/25 13:42
 */
public class LeetCode3623 {

    public int countTrapezoids(int[][] points) {
        int mod = 1_000_000_007;
        HashMap<Integer, Integer> row = new HashMap<>();
        for (int[] p : points) {
            row.merge(p[1], 1, Integer::sum);
        }
        if (row.size() < 2) return 0;
        List<Long> list = new ArrayList<>();
        for (int c : row.values()) {
            long k = (long) c * (c - 1) / 2;
            list.add(k);
        }
        if (list.size() < 2) return 0;
        long sum = 0;
        long ans = 0;
        for (long k : list) {
            ans = (ans + k * sum % mod) % mod;
            sum += k;
        }
        return (int) ans;
    }
}
