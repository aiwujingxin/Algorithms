package leetcode.problems;


import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/22 16:40
 */
public class LeetCode391 {

    public boolean isRectangleCover(int[][] rectangles) {
        int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;

        HashSet<String> points = new HashSet<>();
        int actual_area = 0;
        for (int[] rectangle : rectangles) {
            // 计算完美矩形的理论顶点坐标
            X1 = Math.min(X1, rectangle[0]);
            Y1 = Math.min(Y1, rectangle[1]);
            X2 = Math.max(X2, rectangle[2]);
            Y2 = Math.max(Y2, rectangle[3]);
            // 累加小矩形的面积
            actual_area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            // 记录最终形成的图形中的顶点
            String p1 = rectangle[0] + "," + rectangle[1];
            String p2 = rectangle[0] + "," + rectangle[3];
            String p3 = rectangle[2] + "," + rectangle[1];
            String p4 = rectangle[2] + "," + rectangle[3];
            for (String p : new String[]{p1, p2, p3, p4}) {
                if (points.contains(p)) {
                    points.remove(p);
                } else {
                    points.add(p);
                }
            }
        }
        // 判断面积是否相同
        int expected_area = (X2 - X1) * (Y2 - Y1);
        if (actual_area != expected_area) {
            return false;
        }
        // 判断最终留下的顶点个数是否为 4
        if (points.size() != 4) {
            return false;
        }
        // 判断留下的 4 个顶点是否是完美矩形的顶点
        String[] ps = new String[]{X1 + "," + Y1, X1 + "," + Y2, X2 + "," + Y1, X2 + "," + Y2};
        for (String p : ps) {
            if (!points.contains(p)) {
                return false;
            }
        }
        // 面积和顶点都对应，说明矩形符合题意
        return true;
    }
}

