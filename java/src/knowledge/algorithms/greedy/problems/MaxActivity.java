package knowledge.algorithms.greedy.problems;

import java.util.Arrays;
import java.util.Comparator;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 4/16/25 00:21
 * @description 活动选择
 * @link <a href="https://www.acwing.com/solution/content/16905/"></a>
 * 给定 n 个活动，每个活动 i 有开始时间 start[i] 和结束时间 end[i]。
 * 目标：选择最多的活动，使得它们互不重叠（即任意两个活动的时间区间不重叠）。
 */
public class MaxActivity {

    public int maxActivities(int[][] activities) {
        Arrays.sort(activities, Comparator.comparingInt(o -> o[1]));
        int lastEnd = Integer.MIN_VALUE;
        int cnt = 0;
        for (int[] activity : activities) {
            if (activity[0] >= lastEnd) {
                cnt++;
                lastEnd = activity[1];
            }
        }
        return cnt;
    }
}
