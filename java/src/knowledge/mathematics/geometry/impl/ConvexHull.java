package knowledge.mathematics.geometry.impl;

import java.util.Arrays;

/**
 * 凸包 (Convex Hull) 算法模板
 * 使用 Andrew 的单调链算法 (Andrew's Monotone Chain)
 * 时间复杂度: O(N log N)
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description ConvexHull
 */
public class ConvexHull {

    public static class Point implements Comparable<Point> {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (Double.compare(this.x, o.x) != 0) {
                return Double.compare(this.x, o.x);
            }
            return Double.compare(this.y, o.y);
        }
    }

    /**
     * 计算二维叉积 (Cross Product)
     * 返回 OA 和 OB 的叉积。
     * 结果大于 0 表示逆时针，小于 0 表示顺时针，等于 0 表示三点共线。
     */
    public static double cross(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    /**
     * 获取点集的凸包
     *
     * @param pts 输入的点集
     * @return 构成凸包的点集（逆时针顺序，起点和终点不同）
     */
    public static Point[] getConvexHull(Point[] pts) {
        int n = pts.length, k = 0;
        if (n <= 1) return pts;

        Point[] hull = new Point[2 * n];
        Arrays.sort(pts);

        // 求下凸包
        for (int i = 0; i < n; ++i) {
            while (k >= 2 && cross(hull[k - 2], hull[k - 1], pts[i]) <= 0) {
                k--;
            }
            hull[k++] = pts[i];
        }

        // 求上凸包
        for (int i = n - 2, t = k + 1; i >= 0; i--) {
            while (k >= t && cross(hull[k - 2], hull[k - 1], pts[i]) <= 0) {
                k--;
            }
            hull[k++] = pts[i];
        }

        // k-1 是因为起点和终点重合
        if (k > 1) {
            return Arrays.copyOfRange(hull, 0, k - 1);
        } else {
            return Arrays.copyOfRange(hull, 0, k);
        }
    }
}
