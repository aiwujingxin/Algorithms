package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jingxinwu
 * @date 2023.09.19 17:04
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

    //https://www.cnblogs.com/lightwindy/p/8577794.html
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (q.peek() <= intervals[i][0]) {
                q.poll();
            }
            q.add(intervals[i][1]);
        }
        return q.size();
    }
}
