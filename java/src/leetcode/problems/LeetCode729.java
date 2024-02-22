package leetcode.problems;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 13:43
 */
public class LeetCode729 {
    class MyCalendar {

        TreeSet<int[]> booked;

        public MyCalendar() {
            booked = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
        }

        public boolean book(int start, int end) {
            if (booked.isEmpty()) {
                booked.add(new int[]{start, end});
                return true;
            }
            int[] tmp = {end, 0};
            int[] arr = booked.ceiling(tmp);
            if (arr == booked.first() || booked.lower(tmp)[1] <= start) {
                booked.add(new int[]{start, end});
                return true;
            }
            return false;
        }
    }
}
