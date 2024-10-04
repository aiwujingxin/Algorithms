package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 10/3/24 13:07
 */
public class LeetCode1751 {

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // 按照结束时间排序
        int n = events.length;
        int[][] f = new int[n][k + 1];
        for (int i = 1; i <= k; i++) {
            f[0][i] = events[0][2];
        }
        for (int i = 1; i < n; ++i) {
            int p = search(events, i - 1, events[i][0]);
            for (var j = 1; j <= k; j++)
                f[i][j] = Math.max(f[i - 1][j], (p == -1 ? 0 : f[p][j - 1]) + events[i][2]);
        }
        return f[n - 1][k];
    }

    // 返回 endDay < upper 的最大下标
    private int search(int[][] events, int len, int upper) {
        int l = 0;
        int r = len;
        while (l < r) {
            var mid = l + r + 1 >> 1;
            if (events[mid][1] >= upper) r = mid - 1;
            else l = mid;
        }
        if (events[l][1] >= upper) {
            l--;
        }
        return l;
    }
}
