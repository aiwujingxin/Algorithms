package leetcode.lists.lcr;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 13:17
 */
public class LCR58 {

    class MyCalendar {

        PriorityQueue<int[]> queue;

        public MyCalendar() {
            queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                }
            });
        }

        public boolean book(int start, int end) {
            for (int[] node : queue) {
                if (node[1] > start && node[0] < end) {
                    return false;
                }
            }
            queue.add(new int[]{start, end});
            return true;
        }
    }

}
