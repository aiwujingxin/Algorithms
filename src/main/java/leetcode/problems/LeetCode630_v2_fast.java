package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/10 12:56
 */
public class LeetCode630_v2_fast {

    //https://leetcode.com/contest/leetcode-weekly-contest-38/ranking/1/

    // 贪心 反悔

    public int scheduleCourse(int[][] courses) {
        // 按课程截止时间升序排序
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        // 大根堆，学习时长更长的在堆顶
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // 记录总学习时长
        int total = 0;
        // 按截止时间从近到远遍历课程
        for (int[] course : courses) {
            // 如果总时长不会超过截止时间，那么，当前这门课程可以选择，直接入堆
            if (total + course[0] <= course[1]) {
                total += course[0];
                heap.offer(course);
            } else if (!heap.isEmpty() && heap.peek()[0] > course[0]) {
                // 出现冲突，优先选择学习时长更短的课程
                // 课程时间冲突，且有选过其他课，这时我们找到最长时间的课程，用当前的短课替换了，余出了更多的空区间
                // 所以这里我们余出的时间其实就是两者的持续时间之差，课程变短了，day会前移，这样我们相当于变相给后面的课程增加了选择的区间

                total = total - heap.poll()[0] + course[0];
                heap.offer(course);
            }
        }
        // 堆中有多少课程就是结果
        return heap.size();
    }
}
