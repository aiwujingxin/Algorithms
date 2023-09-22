package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 23:50
 */
public class LeetCode204_bs_TEL {

    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] visited = new boolean[5_000_001];
        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) {
                primes.add(i);
                for (int j = i; j < visited.length; j = j + i) {
                    visited[j] = true;
                }
            }
        }
        int lo = 0, hi = primes.size() - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (primes.get(m) >= n) {
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }
        return hi + 1;
    }
}
