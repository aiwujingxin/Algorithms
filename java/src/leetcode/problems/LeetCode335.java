package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 20:06
 */
public class LeetCode335 {

    public boolean isSelfCrossing(int[] d) {
        int n = d.length;
        if (n < 4) {
            return false;
        }
        for (int i = 3; i < n; i++) {
            if (d[i] >= d[i - 2] && d[i - 1] <= d[i - 3]) {
                return true;
            }
            if (i >= 4 && d[i - 1] == d[i - 3] && d[i] + d[i - 4] >= d[i - 2]) {
                return true;
            }

            if (i >= 5 && d[i - 1] <= d[i - 3] && d[i - 2] > d[i - 4] && d[i] + d[i - 4] >= d[i - 2] && d[i - 1] + d[i - 5] >= d[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
