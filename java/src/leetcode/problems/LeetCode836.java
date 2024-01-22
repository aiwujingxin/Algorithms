package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 14:15
 */
public class LeetCode836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1 = rec1[0];
        int ay1 = rec1[1];
        int ax2 = rec1[2];
        int ay2 = rec1[3];

        int bx1 = rec2[0];
        int by1 = rec2[1];
        int bx2 = rec2[2];
        int by2 = rec2[3];

        // 大左，小右
        int leftMax = Math.max(ax1, bx1);
        int rightMin = Math.min(ax2, bx2);
        // 小上，大下
        int topMin = Math.min(ay2, by2);
        int bottomMax = Math.max(ay1, by1);

        return leftMax < rightMin && topMin > bottomMax;
    }
}
