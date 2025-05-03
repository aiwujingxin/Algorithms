package leetcode.problems;

import knowledge.algorithms.greedy.problems.MaxActivity;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/28 00:12
 * @link <a href="https://www.acwing.com/solution/content/16905/"></a>
 * @see MaxActivity
 */
public class LeetCode452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[2]);
        int lastEnd = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastEnd) { // 不取等号
                cnt++;
                lastEnd = points[i][1];
            }
        }
        return cnt;
    }
}
