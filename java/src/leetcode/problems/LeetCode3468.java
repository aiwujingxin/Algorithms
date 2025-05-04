package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/4/25 22:20
 */
public class LeetCode3468 {

    public int countArrays(int[] original, int[][] bounds) {
        int mn = bounds[0][0], mx = bounds[0][1];
        for (int i = 1; i < bounds.length; i++) {
            int d = original[i] - original[0];
            mn = Math.max(mn, bounds[i][0] - d); // 计算区间交集
            mx = Math.min(mx, bounds[i][1] - d);
        }
        return Math.max(mx - mn + 1, 0); // 注意交集可能是空的
    }
}
