package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/11 23:32
 */
public class LeetCode149 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int res = 2;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                int count = 2;
                for (int k = j + 1; k < n; k++) {
                    int x1 = points[k][0] - points[j][0];
                    int y1 = points[k][1] - points[j][1];
                    // x/y = x1/y1
                    if (x * y1 == y * x1) {
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
