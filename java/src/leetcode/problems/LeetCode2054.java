package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/28 15:28
 */
public class LeetCode2054 {

    public int maxTwoEvents(int[][] events) {
        for (int[] e : events) {
            e[0]--;
        }
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        int n = events.length;
        int[] right = new int[n];
        int rightMax = events[n - 1][2];
        right[n - 1] = rightMax;
        for (int i = n - 1; i >= 0; i--) {
            if (rightMax < events[i][2]) {
                rightMax = events[i][2];
            }
            right[i] = rightMax;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int r = findL(events, i, i + 1, n - 1);
            int rm = r < n ? right[r] : 0;
            ans = Math.max(ans, rm + events[i][2]);
        }
        return ans;
    }

    public int findL(int[][] events, int x, int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (events[mid][0] < events[x][1]) l = mid + 1;
            else r = mid;
        }
        if (l < events.length && events[l][0] < events[x][1]) {
            return l + 1;
        }
        return l;
    }
}
