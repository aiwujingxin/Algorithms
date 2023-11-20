package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/10 12:30
 */
public class LeetCode630 {

    public int scheduleCourse(int[][] courses) {

        if (courses == null || courses.length == 0) {
            return 0;
        }
        if (courses.length == 1) {
            return 1;
        }
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();

        list.add(courses[0]);
        for (int i = 1; i < courses.length; i++) {
            if (courses[i][0] >= list.get(list.size() - 1)[1]) {
                list.add(courses[i]);
            }
        }
        return list.size();
    }

    public int scheduleCourse_Q(int[][] courses) {
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
