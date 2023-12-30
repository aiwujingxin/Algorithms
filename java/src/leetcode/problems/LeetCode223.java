package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 14:39
 */
public class LeetCode223 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        int overlap = 0;
        // 大左，小右
        int leftMax = Math.max(ax1, bx1);
        int rightMin = Math.min(ax2, bx2);
        // 小上，大下
        int topMin = Math.min(ay2, by2);
        int bottomMax = Math.max(ay1, by1);

        if (leftMax < rightMin && topMin > bottomMax) {
            overlap = (rightMin - leftMax) * (topMin - bottomMax);
        }
        return area1 + area2 - overlap;
    }
}
