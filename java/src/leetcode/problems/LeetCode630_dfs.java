package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 22:00
 */
public class LeetCode630_dfs {

    public static int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0) return 0;
        int m = courses.length;
        Arrays.sort(courses, Comparator.comparingInt(i -> i[1]));
        int[][] cache = new int[m][courses[m - 1][1] + 1];
        return schedule(courses, 0, 0, cache);
    }


    public static int schedule(int[][] courses, int day, int index, int[][] cache) {
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
            taken = 1 + schedule(courses, day + cur[0], index + 1, cache);
        }
        int not_taken = schedule(courses, day, index + 1, cache);
        cache[index][day] = Math.max(taken, not_taken);
        return cache[index][day];
    }

}
