package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jingxinwu
 * @date 2023.09.19 17:04
 * @link <a href="https://www.cnblogs.com/lightwindy/p/8577794.html">...</a>
 */
public class LeetCode253 {

    /**
     * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：intervals = [[0,30],[5,10],[15,20]]
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：intervals = [[7,10],[2,4]]
     * 输出：1
     **/
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!queue.isEmpty() && queue.peek() <= interval[0]) {
                queue.poll();
            }
            queue.add(interval[1]);
        }
        return queue.size();
    }
}
