package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 22:00
 */
public class LeetCode630_dfs {

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(i -> i[1]));
        return helper(courses, 0, 0);
    }

    private static int helper(int[][] course, int day, int index) {
        //base
        if (index == course.length) {
            return 0;
        }
        int[] cur = course[index];
        int taken = 0;
        if (day + cur[0] <= cur[1]) {
            taken = 1 + helper(course, day + cur[0], index + 1);
        }
        int not_taken = helper(course, day, index + 1);
        return Math.max(taken, not_taken);
    }
}
