package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/1 23:53
 */
public class LeetCode473 {

    int[] matchsticks;

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int n = matchsticks.length;
        Arrays.sort(matchsticks);
        reverse(matchsticks, 0, n - 1);
        this.matchsticks = matchsticks;
        return backtrack(0, sum / 4, new int[4]);
    }

    private boolean backtrack(int index, int side, int[] edges) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] + matchsticks[index] > side || (i > 0 && edges[i] == edges[i - 1])) {
                continue;
            }
            edges[i] += matchsticks[index];
            if (backtrack(index + 1, side, edges)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    public void reverse(int[] chars, int i, int j) {
        while (i < j) {
            int t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
    }
}
