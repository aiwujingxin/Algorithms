package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/27 23:19
 * <a href="https://www.youtube.com/watch?v=5sE0cQVhfFo"></a>
 */

public class LeetCode452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int res = 1;
        int[] start = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (curr[0] > start[1]) {
                res++;
                start = curr;
            } else {
                start[0] = Math.max(start[0], curr[0]);
                start[1] = Math.min(start[1], curr[1]);
            }
        }
        return res;
    }
}
