package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 15:47
 */
public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, res = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                res++;
                i++;
            }
            j++;
        }
        return res;
    }
}
