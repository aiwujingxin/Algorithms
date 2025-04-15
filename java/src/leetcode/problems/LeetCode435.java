package leetcode.problems;

import knowledge.algorithms.greedy.problems.MaxActivity;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 17:23
 * @description 找到最大不重叠区间的个数
 * @see MaxActivity
 */
public class LeetCode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - new MaxActivity().maxActivities(intervals);
    }
}
