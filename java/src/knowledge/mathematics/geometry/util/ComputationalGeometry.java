package knowledge.mathematics.geometry.util;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26 12:00
 * @description 二维计算几何基础模板
 * <核心约定>
 * 1. 整数坐标优先使用叉积做精确判定，不使用斜率，避免除零和浮点误差。
 * 2. cross(a,b,c)>0 表示 a→b→c 逆时针，<0 表示顺时针，=0 表示共线。
 * 3. 线段相交必须同时处理跨立实验与共线端点重合。
 * 4. 面积先保留“二倍有向面积”，最后再除以 2，避免过早损失精度。
 * <溢出提醒>
 * 本模板通过 exact 算术主动抛出 long 溢出；若坐标接近 10^9 且点数很多，
 * 应根据题目上界改用 BigInteger 或专门的 128 位实现。
 */
public final class ComputationalGeometry {

    public static final double EPS = 1e-9;

    private ComputationalGeometry() {
    }

    public static final class Point {
        public final long x;
        public final long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Point)) return false;
            Point other = (Point) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return 31 * Long.hashCode(x) + Long.hashCode(y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    /**
     * 向量 oa × ob。
     */
    public static long cross(Point origin, Point a, Point b) {
        long ax = Math.subtractExact(a.x, origin.x);
        long ay = Math.subtractExact(a.y, origin.y);
        long bx = Math.subtractExact(b.x, origin.x);
        long by = Math.subtractExact(b.y, origin.y);
        return Math.subtractExact(Math.multiplyExact(ax, by), Math.multiplyExact(ay, bx));
    }

    /**
     * 点积 oa · ob；符号可判断夹角锐钝及投影方向。
     */
    public static long dot(Point origin, Point a, Point b) {
        long ax = Math.subtractExact(a.x, origin.x);
        long ay = Math.subtractExact(a.y, origin.y);
        long bx = Math.subtractExact(b.x, origin.x);
        long by = Math.subtractExact(b.y, origin.y);
        return Math.addExact(Math.multiplyExact(ax, bx), Math.multiplyExact(ay, by));
    }

    public static int orientation(Point a, Point b, Point c) {
        return Long.compare(cross(a, b, c), 0);
    }

    public static boolean onSegment(Point point, Point a, Point b) {
        return orientation(a, b, point) == 0
                && between(point.x, a.x, b.x)
                && between(point.y, a.y, b.y);
    }

    /**
     * 判断两条闭线段是否相交，端点接触和共线重叠均视为相交。
     */
    public static boolean segmentsIntersect(Point a, Point b, Point c, Point d) {
        int abC = orientation(a, b, c);
        int abD = orientation(a, b, d);
        int cdA = orientation(c, d, a);
        int cdB = orientation(c, d, b);
        if (abC == 0 && onSegment(c, a, b)) return true;
        if (abD == 0 && onSegment(d, a, b)) return true;
        if (cdA == 0 && onSegment(a, c, d)) return true;
        if (cdB == 0 && onSegment(b, c, d)) return true;
        return abC != abD && cdA != cdB;
    }

    /**
     * 多边形二倍有向面积。正数表示顶点逆时针排列，负数表示顺时针。
     */
    public static long signedDoubleArea(List<Point> polygon) {
        long area = 0;
        for (int i = 0; i < polygon.size(); i++) {
            Point current = polygon.get(i);
            Point next = polygon.get((i + 1) % polygon.size());
            long term = Math.subtractExact(
                    Math.multiplyExact(current.x, next.y),
                    Math.multiplyExact(current.y, next.x));
            area = Math.addExact(area, term);
        }
        return area;
    }

    public static double area(List<Point> polygon) {
        return Math.abs((double) signedDoubleArea(polygon)) / 2.0;
    }

    public static long squaredDistance(Point a, Point b) {
        long dx = Math.subtractExact(a.x, b.x);
        long dy = Math.subtractExact(a.y, b.y);
        return Math.addExact(Math.multiplyExact(dx, dx), Math.multiplyExact(dy, dy));
    }

    public static int compare(double a, double b) {
        double difference = a - b;
        if (Math.abs(difference) <= EPS) return 0;
        return difference < 0 ? -1 : 1;
    }

    /**
     * 两直线 ab 与 cd 的交点（double 坐标）。平行或重合返回 null。
     */
    public static double[] lineIntersection(Point a, Point b, Point c, Point d) {
        long d1x = b.x - a.x, d1y = b.y - a.y;
        long d2x = d.x - c.x, d2y = d.y - c.y;
        long denominator = d1x * d2y - d1y * d2x;
        if (denominator == 0) return null;
        long numerator = (c.x - a.x) * d2y - (c.y - a.y) * d2x;
        double t = (double) numerator / denominator;
        return new double[]{a.x + t * d1x, a.y + t * d1y};
    }

    /**
     * 点 p 到线段 ab 的最短距离（欧氏距离）。
     */
    public static double pointToSegmentDistance(Point p, Point a, Point b) {
        long abx = b.x - a.x, aby = b.y - a.y;
        long apx = p.x - a.x, apy = p.y - a.y;
        long dotProduct = abx * apx + aby * apy;
        if (dotProduct <= 0) return Math.sqrt(squaredDistance(p, a));
        long lengthSquared = abx * abx + aby * aby;
        if (dotProduct >= lengthSquared) return Math.sqrt(squaredDistance(p, b));
        double t = (double) dotProduct / lengthSquared;
        double footX = a.x + t * abx, footY = a.y + t * aby;
        double dx = p.x - footX, dy = p.y - footY;
        return Math.hypot(dx, dy);
    }

    /**
     * 点 p 到直线 ab 的距离，用叉积面积除以底边长度。
     */
    public static double pointToLineDistance(Point p, Point a, Point b) {
        double area2 = Math.abs(cross(a, b, p));
        return area2 / Math.sqrt(squaredDistance(a, b));
    }

    /**
     * 简单多边形边界上的格点数：各边端点差的 gcd 之和。
     */
    public static long boundaryLatticePoints(List<Point> polygon) {
        long count = 0;
        int size = polygon.size();
        for (int i = 0; i < size; i++) {
            Point current = polygon.get(i);
            Point next = polygon.get((i + 1) % size);
            count += gcd(Math.abs(current.x - next.x), Math.abs(current.y - next.y));
        }
        return count;
    }

    /**
     * Pick 定理求内部格点数 I = A - B/2 + 1。
     * A 为多边形面积，B 为边界格点数（要求顶点均为整点）。
     */
    public static long interiorLatticePoints(List<Point> polygon) {
        long doubleArea = Math.abs(signedDoubleArea(polygon));
        long boundary = boundaryLatticePoints(polygon);
        return (doubleArea - boundary + 2) / 2;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static boolean between(long value, long endpoint1, long endpoint2) {
        return value >= Math.min(endpoint1, endpoint2)
                && value <= Math.max(endpoint1, endpoint2);
    }
}
