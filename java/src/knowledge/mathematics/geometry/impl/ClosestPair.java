package knowledge.mathematics.geometry.impl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 最近点对 (分治)
 * <适用场景>
 * 平面上 n 个点，求距离最近的一对点。朴素枚举 O(n^2)，分治降到 O(n log n)。
 * <核心思想>
 * 按 x 排序后二分区间，分别求左右最近距离 d；跨越中线的点对只可能落在宽 2d 的竖带里，
 * 带内点按 y 排序后每个点至多与后续 7 个点比较，保证线性合并。
 */
public class ClosestPair {

    public static class Point {
        public final double x;
        public final double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static double distance(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    /**
     * 返回最近点对的距离。
     */
    public static double closest(Point[] points) {
        Point[] byX = points.clone();
        Arrays.sort(byX, Comparator.comparingDouble(p -> p.x));
        Point[] byY = byX.clone();
        Arrays.sort(byY, Comparator.comparingDouble(p -> p.y));
        return solve(byX, byY, 0, byX.length - 1);
    }

    private static double solve(Point[] byX, Point[] byY, int left, int right) {
        if (right - left <= 2) {
            double best = Double.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    best = Math.min(best, distance(byX[i], byX[j]));
                }
            }
            return best;
        }
        int mid = (left + right) >>> 1;
        double midX = byX[mid].x;
        double best = Math.min(solve(byX, byY, left, mid), solve(byX, byY, mid + 1, right));

        // 竖带内的点按 y 有序枚举
        Point[] strip = new Point[right - left + 1];
        int size = 0;
        for (Point p : byY) {
            if (Math.abs(p.x - midX) < best) strip[size++] = p;
        }
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && strip[j].y - strip[i].y < best; j++) {
                best = Math.min(best, distance(strip[i], strip[j]));
            }
        }
        return best;
    }
}
