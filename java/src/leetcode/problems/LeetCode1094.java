package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 14:23
 */
public class LeetCode1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int n = 1001;
        int[] diff = new int[n];
        for (int[] trip : trips) {
            //乘客在车上的区间是 [trip[1], trip[2] - 1]
            diff[trip[1]] += trip[0];
            diff[trip[2] - 1 + 1] -= trip[0];
        }
        int cur = 0;
        for (int d : diff) {
            cur += d;
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }
}
