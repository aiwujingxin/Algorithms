package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/10 12:39
 */
public class LeetCode630_v1 {

    public static void main(String[] args) {
        System.out.println(LeetCode630_v1.ScheduleGreedy(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
    }

    public static int scheduleCourseDfsRecursive(int[][] courses) {
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

    public static int scheduleDfsCacheDP(int[][] courses) {
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
        if (cache[index][day] != 0) return cache[index][day];
        int taken = 0;
        int[] cur = courses[index];
        if (day + cur[0] <= cur[1]) {
            taken = 1 + schedule(courses, day + cur[0], index + 1, cache);
        }
        int not_taken = schedule(courses, day, index + 1, cache);
        cache[index][day] = Math.max(taken, not_taken);
        return cache[index][day];
    }

    public static int ScheduleGreedy(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(i -> i[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>((i, j) -> j - i); //max heap
        int time = 0;
        for (int[] cur : courses) {
            time += cur[0];
            q.add(cur[0]);
            if (time > cur[1]) {
                time -= q.poll();
            }
        }
        return q.size();
    }
}

