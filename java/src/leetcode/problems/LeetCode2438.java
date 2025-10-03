package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/12/25 16:02
 */
public class LeetCode2438 {

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int mod = 1_000_000_007;
        for (int i = 30; i >= 0; i--) {
            if (n >= (1 << i)) {
                powers.add(0, i);
                n -= 1 << i;
            }
        }
        int[] s = new int[powers.size() + 1];
        for (int i = 1; i <= powers.size(); i++) {
            s[i] = s[i - 1] + powers.get(i - 1);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int pow = s[right + 1] - s[left];
            ans[i] = (int) (Math.pow(2, pow) % mod);
        }
        return ans;
    }
}
