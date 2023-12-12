package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/12 17:59
 */
public class LeetCode1553 {

    Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3)));
        return memo.get(n);
    }
}
