package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-08-24 11:59 下午
 */
public class LeetCode223 {

    public static void main(String[] args) {
        LeetCode223 leetCode223 = new LeetCode223();
//        System.out.println(leetCode223.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
//        System.out.println(leetCode223.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
//        System.out.println(leetCode223.computeArea(0, 0, 0, 0, -1, -1, 1, 1));
        System.out.println(leetCode223.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = computeArea(ax1, ay1, ax2, ay2);
        int area2 = computeArea(bx1, by1, bx2, by2);
        if (area1 == 0) {
            return area2;
        }
        if (area2 == 0) {
            return area1;
        }
        //根据两个垂直的线，求出重叠部分的长度，作为宽
        int a = computeHight(ay1, ay2, by1, by2);
        //根据两个水平的线，求出重叠部分的长度，作为长
        int b = computeWight(ax1, ax2, bx1, bx2);
        //重叠的面积=长*宽
        //结果=两个面积除去重叠的面积
        return area1 + area2 - ((a > 0 && b > 0) ? a * b : 0);
    }

    public int computeHight(int ay1, int ay2, int by1, int by2) {
        if (ay1 == 0 && ay2 == 0) {
            return Math.abs(by2 - by1);
        }
        if (by1 == 0 && by2 == 0) {
            return Math.abs(ay2 - ay1);
        }
        int top = Math.min(ay2, by2);
        int bot = Math.max(ay1, by1);
        return top - bot;
    }

    public int computeWight(int ax1, int ax2, int bx1, int bx2) {
        if (ax1 == 0 && ax2 == 0) {
            return Math.abs(bx2 - bx1);
        }
        if (bx1 == 0 && bx2 == 0) {
            return Math.abs(ax2 - ax1);
        }
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        return right - left;
    }

    public int computeArea(int x1, int y1, int x2, int y2) {
        //根据两个垂直的线，求出重叠部分的长度，作为宽
        return Math.abs(y2 - y1) * Math.abs(x2 - x1);
    }
}
