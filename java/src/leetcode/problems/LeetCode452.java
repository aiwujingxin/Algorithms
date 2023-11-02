package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/28 00:12
 * @see LeetCode435
 */
public class LeetCode452 {

    //https://www.acwing.com/solution/content/16905/
    // 证明：最优解ans 所有合法方案中的最小值，贪心解cnt
    //（1）上述选法必然会使每个区间里至少包含一个点，是一种合法方案，所以ans<=cnt
    //（2）通过贪心方案我们知道序列中包含了cnt个相互之间没有交集的区间，所以对于一个合法方案，必然至少包含cnt个点，所以cnt<=ans
    // 感觉和跳跃游戏差不多: 不是感觉 就是
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        int end = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > end) {
                end = balloon[1];
                ans++;
            }
        }
        return ans;
    }
}
