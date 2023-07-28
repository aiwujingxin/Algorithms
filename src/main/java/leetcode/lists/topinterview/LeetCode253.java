package leetcode.lists.topinterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 15:29
 */
public class LeetCode253 {

    //输入：intervals = [[0,30],[5,10],[15,20]]
    //输出：2

    //fix
    //[[5,8],[6,8]]
    //1

    //fix
    //[[7,10],[2,4]]

    //fix
    //[[2,15],[36,45],[9,29],[16,23],[4,9]]

    public static void main(String[] args) {
        System.out.println(new LeetCode253().minMeetingRooms(new int[][]{{5, 8}, {6, 8}}));
        System.out.println(new LeetCode253().minMeetingRooms(new int[][]{{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}}));
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] interval : intervals) {
            if (!queue.isEmpty() && queue.peek()[1] <= interval[0]) {
                queue.poll();
            }
            queue.add(interval);
        }
        return queue.size();
    }
}
