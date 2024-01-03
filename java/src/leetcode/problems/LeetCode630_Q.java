package leetcode.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 13:50
 */
public class LeetCode630_Q {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int[] c : courses) {
            int d = c[0], e = c[1];
            sum += d;
            q.add(d);
            if (sum > e) {
                sum -= q.poll();
            }
        }
        return q.size();
    }
}
