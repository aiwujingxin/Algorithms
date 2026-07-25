package knowledge.mathematics.geometry.impl;

import java.util.*;

/**
 * 最小圆覆盖 (Minimum Enclosing Circle) 算法模板
 * 使用 Welzl 算法，采用随机增量法
 * 期望时间复杂度: O(N)
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description MinimumEnclosingCircle
 */
public class MinimumEnclosingCircle {

    public static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Circle {
        public Point center;
        public double radius;

        public Circle(Point center, double radius) {
            this.center = center;
            this.radius = radius;
        }
    }

    private static double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    private static boolean isInside(Circle c, Point p) {
        return c != null && dist(c.center, p) <= c.radius + 1e-9;
    }

    // 求两点为直径的圆
    private static Circle circleFrom(Point a, Point b) {
        Point center = new Point((a.x + b.x) / 2.0, (a.y + b.y) / 2.0);
        return new Circle(center, dist(a, b) / 2.0);
    }

    // 求三点外接圆
    private static Circle circleFrom(Point a, Point b, Point c) {
        double bx = b.x - a.x, by = b.y - a.y;
        double cx = c.x - a.x, cy = c.y - a.y;
        double B = bx * bx + by * by;
        double C = cx * cx + cy * cy;
        double D = bx * cy - by * cx;

        Point center = new Point((cy * B - by * C) / (2 * D), (bx * C - cx * B) / (2 * D));
        center.x += a.x;
        center.y += a.y;

        return new Circle(center, dist(center, a));
    }

    // 递归辅助函数
    private static Circle welzlHelper(List<Point> P, List<Point> R, int n) {
        if (n == 0 || R.size() == 3) {
            if (R.isEmpty()) {
                return new Circle(new Point(0, 0), 0);
            }
            if (R.size() == 1) {
                return new Circle(R.get(0), 0);
            }
            if (R.size() == 2) {
                return circleFrom(R.get(0), R.get(1));
            }
            return circleFrom(R.get(0), R.get(1), R.get(2));
        }

        Point p = P.get(n - 1);
        Circle c = welzlHelper(P, R, n - 1);

        if (isInside(c, p)) {
            return c;
        }

        R.add(p);
        Circle res = welzlHelper(P, R, n - 1);
        R.remove(R.size() - 1);

        return res;
    }

    /**
     * 获取给定点集的最小外接圆
     *
     * @param points 点集
     * @return 最小外接圆
     */
    public static Circle getMinimumEnclosingCircle(Point[] points) {
        List<Point> pList = new ArrayList<>(Arrays.asList(points));
        // 打乱顺序以保证期望 O(N) 复杂度
        Collections.shuffle(pList, new Random(42));
        return welzlHelper(pList, new ArrayList<>(), pList.size());
    }
}
