package knowledge.mathematics.geometry.impl;

/**
 * 旋转卡壳 (Rotating Calipers) 算法模板
 * 常用于求解凸多边形的最远点对（直径）
 * 时间复杂度: O(N) (假设输入已经是凸包)
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description RotatingCalipers
 */
public class RotatingCalipers {

    public static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 计算两点间的距离平方
     */
    public static double dist2(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    /**
     * 计算二维叉积
     */
    public static double cross(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    /**
     * 求解凸多边形的直径（最远点对距离）
     * 注意：输入的 pts 必须是按逆时针顺序排列的凸包顶点集合，不能有共线点
     *
     * @param pts 凸包点集
     * @return 凸多边形的直径
     */
    public static double getDiameter(Point[] pts) {
        int n = pts.length;
        if (n == 1) return 0;
        if (n == 2) return Math.sqrt(dist2(pts[0], pts[1]));

        double maxDist = 0;
        // i 为边的一个端点，j 为对踵点
        for (int i = 0, j = 2; i < n; i++) {
            Point p1 = pts[i];
            Point p2 = pts[(i + 1) % n];

            // 比较叉积（三角形面积），寻找距离当前边最远的顶点
            while (cross(p1, p2, pts[(j + 1) % n]) > cross(p1, p2, pts[j])) {
                j = (j + 1) % n;
            }

            // 更新最大距离
            maxDist = Math.max(maxDist, Math.max(dist2(p1, pts[j]), dist2(p2, pts[j])));
        }

        return Math.sqrt(maxDist);
    }
}
