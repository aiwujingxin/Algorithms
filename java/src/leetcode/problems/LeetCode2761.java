package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 13:49
 */
public class LeetCode2761 {

    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] dp = new boolean[n + 1];
        HashSet<Integer> set = new HashSet<>();
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!dp[i]) {
                set.add(i);
                for (int j = 0; j * i <= n; j++) {
                    dp[i * j] = true;
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (set.contains(n - i) &&  set.contains(i)) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(n - i);
                list.add(l);
            }
        }
        return list;
    }
}
