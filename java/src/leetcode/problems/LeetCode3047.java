package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/9/25 17:18
 */
public class LeetCode3047 {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long l = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long r = Math.min(topRight[i][0], topRight[j][0]);
                long u = Math.min(topRight[i][1], topRight[j][1]);
                long d = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                if (l >= r || u <= d) {
                    continue;
                }
                long len = Math.min(r - l, u - d);
                ans = Math.max(ans, len * len);
            }
        }
        return ans;
    }
}
