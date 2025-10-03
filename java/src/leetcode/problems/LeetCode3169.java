package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/16/25 17:36
 */
public class LeetCode3169 {

    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int cnt = 0;
        cnt += meetings[0][0] - 1;
        int max = meetings[0][1];
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > max) {
                cnt += meetings[i][0] - max - 1;
            }
            max = Math.max(max, meetings[i][1]);
        }
        return cnt + days - max;
    }
}
