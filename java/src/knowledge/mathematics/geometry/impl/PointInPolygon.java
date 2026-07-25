package knowledge.mathematics.geometry.impl;

/**
 * 判断点是否在多边形内部 (Point in Polygon) 算法模板
 * 采用射线法 (Ray-casting algorithm)
 * 时间复杂度: O(N)
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description PointInPolygon
 */
public class PointInPolygon {

    public static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 判断点 p 是否在多边形内
     *
     * @param polygon 多边形顶点数组（按顺时针或逆时针给出均可）
     * @param p       需要判断的点
     * @return 0 表示在外部，1 表示在内部，2 表示在边界上
     */
    public static int contains(Point[] polygon, Point p) {
        int n = polygon.length;
        boolean in = false;

        for (int i = 0, j = n - 1; i < n; j = i++) {
            Point a = polygon[i];
            Point b = polygon[j];

            // 判断点是否在多边形的当前边上
            if (onSegment(a, b, p)) {
                return 2; // 在边界上
            }

            // 射线法：从点 p 向右发出一条水平射线，统计与多边形边的交点数
            // 如果一条边的一个端点在射线之上，另一个端点在射线之下或之上，即可判断交点
            if ((a.y > p.y) != (b.y > p.y)) {
                // 计算线段与水平射线 y = p.y 的交点的 x 坐标
                double xIntersect = (b.x - a.x) * (p.y - a.y) / (b.y - a.y) + a.x;
                // 如果交点在 p 点右侧，则射线与该边相交
                if (p.x < xIntersect) {
                    in = !in; // 交点数奇偶性取反
                }
            }
        }

        return in ? 1 : 0;
    }

    /**
     * 判断点 p 是否在线段 ab 上
     */
    private static boolean onSegment(Point a, Point b, Point p) {
        // 先检查 p 的包围盒是否在 a 和 b 的包围盒内
        if (p.x < Math.min(a.x, b.x) || p.x > Math.max(a.x, b.x) ||
                p.y < Math.min(a.y, b.y) || p.y > Math.max(a.y, b.y)) {
            return false;
        }
        // 再检查叉积是否为 0 (判断共线)
        return Math.abs(crossProduct(a, b, p)) < 1e-9;
    }

    /**
     * 计算向量 AB 与 向量 AP 的叉积
     */
    private static double crossProduct(Point a, Point b, Point p) {
        return (b.x - a.x) * (p.y - a.y) - (b.y - a.y) * (p.x - a.x);
    }
}
