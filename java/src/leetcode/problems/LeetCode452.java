package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/28 00:12
 * @link <a href="https://www.acwing.com/solution/content/16905/"></a>
 * @see LeetCode435
 */
public class LeetCode452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int end = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                cnt++;
                end = points[i][1];
            }
        }
        return cnt;
    }
}
