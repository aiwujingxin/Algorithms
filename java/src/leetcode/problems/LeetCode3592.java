package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 10/10/25 16:42
 */
public class LeetCode3592 {

    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length;
        List<Integer> ans = new ArrayList<>();
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            if (numWays[i] - f[i] == 1) {
                ans.add(i + 1);
                f[i] += 1;
                for (int c = i + 1; c < n; c++) {
                    f[c] += f[c - i - 1];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (numWays[i] != f[i]) {
                return new ArrayList<>();
            }
        }
        return ans;
    }
}
