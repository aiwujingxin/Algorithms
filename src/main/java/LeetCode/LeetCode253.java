package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jingxinwu
 * @date 2021-12-19 8:07 PM
 */
public class LeetCode253 {

    //https://www.cnblogs.com/lightwindy/p/8577794.html

    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && intervals[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i].end);
        }
        return pq.size();
    }


    class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
