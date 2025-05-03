package knowledge.algorithms.greedy.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 4/16/25 00:21
 * @description 活动选择
 * 给定 n 个活动，每个活动 i 有开始时间 start[i] 和结束时间 end[i]。
 * 目标：选择最多的活动，使得它们互不重叠（即任意两个活动的时间区间不重叠）。
 * @see leetcode.problems.LeetCode435
 * @see leetcode.problems.LeetCode452
 */
public class MaxActivity {

    public int maxActivities(int[][] activities) {
        Arrays.sort(activities, (o1, o2) -> o1[1] - o2[2]);
        int lastEnd = activities[0][1];
        int cnt = 1;
        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] >= lastEnd) {
                cnt++;
                lastEnd = activities[i][1];
            }
        }
        return cnt;
    }
}
