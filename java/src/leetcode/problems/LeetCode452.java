package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/28 00:12
 */
public class LeetCode452 {

    //https://www.acwing.com/solution/content/16905/
    // 证明：
    // 最优解ans: 所有合法方案中的最小值
    // 贪心解cnt
    // 证明ans<=cnt : 首先确保按照贪心方案 的 cnt 是一种可行方案 没有遗漏
    // 证明ans>=cnt : 按照贪心方案的cnt可行方案是一个区间集合，区间从小到大排序，两两之间不相交。所以覆盖每一个区间至少需要cnt个点。
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int res = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                res++;
            }
        }
        return res;
    }
}
