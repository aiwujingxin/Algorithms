package knowledge.mathematics.geometry.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 凸多边形 O(log n) 点定位
 * <适用场景>
 * 对固定的凸多边形做大量“点是否在内部”查询。射线法每次 O(n)，
 * 而利用凸性以 poly[0] 为原点做扇形二分，可将单次查询降到 O(log n)。
 * <前置条件>
 * 顶点按逆时针给出，且不含三点共线。返回 true 表示点在多边形内部或边界上。
 */
public class ConvexPolygonContains {

    public static class Point {
        public final long x;
        public final long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static long cross(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    /**
     * 判断 p 是否落在逆时针凸多边形 polygon 内部或边界上。
     */
    public static boolean contains(Point[] polygon, Point p) {
        int n = polygon.length;
        // p 必须在 poly[0]->poly[1] 左侧、poly[0]->poly[n-1] 右侧构成的扇形范围内
        if (cross(polygon[0], polygon[1], p) < 0) return false;
        if (cross(polygon[0], polygon[n - 1], p) > 0) return false;
        int lo = 1, hi = n - 1;
        while (hi - lo > 1) {
            int mid = (lo + hi) >>> 1;
            if (cross(polygon[0], polygon[mid], p) >= 0) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        // 落在三角形 poly[0], poly[lo], poly[lo+1] 内
        return cross(polygon[lo], polygon[lo + 1], p) >= 0;
    }
}
