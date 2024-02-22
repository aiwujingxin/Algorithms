package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 17:42
 */
public class LeetCode498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                list.add(new Point(j, -i, mat[i][j]));
            }
        }
        list.sort((o1, o2) -> {
            if (o1.y - o1.x == o2.y - o2.x) {
                if ((o1.y - o1.x) % 2 == 0) {
                    return o1.x - o2.x;
                } else {
                    return o2.x - o1.x;
                }
            } else {
                return o2.y - o2.x - (o1.y - o1.x);
            }
        });

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).v;
        }
        return ans;
    }

    static class Point {
        int x;
        int y;
        int v;

        public Point(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

}
