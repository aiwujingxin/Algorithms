package knowledge.mathematics.geometry.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 半平面交
 * <适用场景>
 * 一组半平面（有向直线左侧区域）的公共区域，是线性规划可行域、核可见区域、
 * 多边形内偏移等问题的通用工具。
 * <核心思想>
 * 每个半平面用一条有向直线表示，按极角排序后用双端队列增量维护：
 * 队尾/队首若被新直线与其相邻交点淘汰则弹出，最终队列围成凸多边形交集。
 */
public class HalfPlaneIntersection {

    private static final double EPS = 1e-9;

    /**
     * 有向直线：点 (px,py) + 方向向量 (dx,dy)，其左侧为半平面。
     */
    public static class Line {
        double px, py, dx, dy, angle;

        public Line(double px, double py, double dx, double dy) {
            this.px = px;
            this.py = py;
            this.dx = dx;
            this.dy = dy;
            this.angle = Math.atan2(dy, dx);
        }
    }

    private static double cross(double ax, double ay, double bx, double by) {
        return ax * by - ay * bx;
    }

    // 点 p 是否在有向直线 l 左侧
    private static boolean onLeft(Line l, double[] p) {
        return cross(l.dx, l.dy, p[0] - l.px, p[1] - l.py) > EPS;
    }

    // 两有向直线交点
    private static double[] intersect(Line a, Line b) {
        double t = cross(b.dx, b.dy, a.px - b.px, a.py - b.py)
                / cross(a.dx, a.dy, b.dx, b.dy);
        return new double[]{a.px + a.dx * t, a.py + a.dy * t};
    }

    /**
     * 求半平面交的顶点（逆时针）。区域为空返回空列表。
     */
    public static List<double[]> intersection(List<Line> lines) {
        Line[] sorted = lines.toArray(new Line[0]);
        Arrays.sort(sorted, Comparator.comparingDouble(l -> l.angle));

        int n = sorted.length;
        Line[] queue = new Line[n + 1];
        double[][] points = new double[n + 1][];   // points[i] = 交点(queue[i], queue[i+1])
        int head = 0, tail = 0;
        queue[0] = sorted[0];
        for (int i = 1; i < n; i++) {
            // 极角相同只保留一条（更靠左的已排序在后，这里简单跳过重复方向）
            if (Math.abs(sorted[i].angle - sorted[i - 1].angle) < EPS) continue;
            while (head < tail && !onLeft(sorted[i], points[tail - 1])) tail--;
            while (head < tail && !onLeft(sorted[i], points[head])) head++;
            queue[++tail] = sorted[i];
            points[tail - 1] = intersect(queue[tail - 1], queue[tail]);
        }
        while (head < tail && !onLeft(queue[head], points[tail - 1])) tail--;
        if (tail - head < 2) return new ArrayList<>();
        points[tail] = intersect(queue[tail], queue[head]);

        List<double[]> polygon = new ArrayList<>();
        for (int i = head; i <= tail; i++) polygon.add(points[i]);
        return polygon;
    }
}
