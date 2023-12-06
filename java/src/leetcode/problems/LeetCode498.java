package leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 10:28
 */
public class LeetCode498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }
        int m = mat.length;
        int n = mat[0].length;

        List<Point> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                list.add(new Point(j, -i, mat[i][j]));
            }
        }
        list.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.y - o1.x == o2.y - o2.x) {
                    if ((o1.y - o1.x) % 2 == 0) {
                        return o1.y - o2.y;
                    } else {
                        return o2.y - o1.y;
                    }
                }
                return (o2.y - o2.x) - (o1.y - o1.x);
            }
        });
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).val;
        }
        return res;

    }

    static class Point {
        int x;
        int y;
        int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
