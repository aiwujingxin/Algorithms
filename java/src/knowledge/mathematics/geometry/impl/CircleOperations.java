package knowledge.mathematics.geometry.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 圆的相交运算 (圆-线 / 圆-圆)
 * <适用场景>
 * 求圆与直线、圆与圆的交点，用于覆盖、可见性、几何构造类题目。
 * <数值纪律>
 * 全程 double + EPS 判定；无交点返回空数组，相切返回单点，相交返回两点。
 */
public class CircleOperations {

    private static final double EPS = 1e-9;

    public static class Point {
        public final double x;
        public final double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 圆心 center 半径 r 的圆与直线 ab 的交点。
     */
    public static Point[] circleLine(Point center, double r, Point a, Point b) {
        double dx = b.x - a.x, dy = b.y - a.y;
        double fx = a.x - center.x, fy = a.y - center.y;
        double A = dx * dx + dy * dy;
        double B = 2 * (fx * dx + fy * dy);
        double C = fx * fx + fy * fy - r * r;
        double discriminant = B * B - 4 * A * C;
        if (discriminant < -EPS) return new Point[0];
        discriminant = Math.max(discriminant, 0);
        double sqrt = Math.sqrt(discriminant);
        double t1 = (-B + sqrt) / (2 * A);
        double t2 = (-B - sqrt) / (2 * A);
        if (Math.abs(t1 - t2) < EPS) {
            return new Point[]{new Point(a.x + t1 * dx, a.y + t1 * dy)};
        }
        return new Point[]{
                new Point(a.x + t1 * dx, a.y + t1 * dy),
                new Point(a.x + t2 * dx, a.y + t2 * dy)
        };
    }

    /**
     * 两圆 (c1,r1)(c2,r2) 的交点。同心或分离/内含返回空数组。
     */
    public static Point[] circleCircle(Point c1, double r1, Point c2, double r2) {
        double dx = c2.x - c1.x, dy = c2.y - c1.y;
        double d = Math.hypot(dx, dy);
        if (d < EPS) return new Point[0];
        if (d > r1 + r2 + EPS || d < Math.abs(r1 - r2) - EPS) return new Point[0];
        double a = (r1 * r1 - r2 * r2 + d * d) / (2 * d);
        double h2 = r1 * r1 - a * a;
        double h = Math.sqrt(Math.max(h2, 0));
        double midX = c1.x + a * dx / d, midY = c1.y + a * dy / d;
        if (h < EPS) return new Point[]{new Point(midX, midY)};
        double offsetX = -dy * h / d, offsetY = dx * h / d;
        return new Point[]{
                new Point(midX + offsetX, midY + offsetY),
                new Point(midX - offsetX, midY - offsetY)
        };
    }
}
