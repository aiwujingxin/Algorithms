package leetcode.problems;

import knowledge.algorithms.greedy.problems.MaxActivity;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 17:23
 * @description 尽可能保留最多的不重叠区间
 */
public class LeetCode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - new MaxActivity().maxActivities(intervals);
    }
}
