package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 18:27
 */
public class LeetCode2509 {

    public int[] cycleLengthQueries(int n, int[][] queries) {
        var m = queries.length;
        var ans = new int[m];
        for (var i = 0; i < m; ++i) {
            int res = 1, a = queries[i][0], b = queries[i][1];
            while (a != b) {
                if (a > b) {
                    a /= 2;
                } else {
                    b /= 2;
                }
                ++res;
            }
            ans[i] = res;
        }
        return ans;
    }
}
