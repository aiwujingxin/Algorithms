package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jingxinwu
 * @date 2021-12-19 8:07 PM
 */
public class LeetCode253 {

    /**
     * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量 。
     *
     * 示例 1：
     *
     * 输入：intervals = [[0,30],[5,10],[15,20]]
     * 输出：2
     * 示例 2：
     *
     * 输入：intervals = [[7,10],[2,4]]
     * 输出：1
     **/

    //https://www.cnblogs.com/lightwindy/p/8577794.html
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> allocator = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}
