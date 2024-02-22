package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 13:50
 */
public class LeetCode630 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
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

    public int scheduleCourse_dp(int[][] courses) {
        if (courses == null || courses.length == 0) return 0;
        int m = courses.length;
        Arrays.sort(courses, Comparator.comparingInt(i -> i[1]));
        int[][] cache = new int[m][courses[m - 1][1] + 1];
        return dfs(courses, 0, 0, cache);
    }


    public int dfs(int[][] courses, int day, int index, int[][] cache) {
        //base
        if (index == courses.length) {
            return 0;
        }
        if (cache[index][day] != 0) {
            return cache[index][day];
        }
        int taken = 0;
        int[] cur = courses[index];
        if (day + cur[0] <= cur[1]) {
            taken = 1 + dfs(courses, day + cur[0], index + 1, cache);
        }
        int not_taken = dfs(courses, day, index + 1, cache);
        cache[index][day] = Math.max(taken, not_taken);
        return cache[index][day];
    }
}
