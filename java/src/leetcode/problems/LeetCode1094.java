package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 14:23
 */
public class LeetCode1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int n = 1001;
        int[] nums = new int[n];
        int[] diff = new int[n];
        for (int[] trip : trips) {
            //乘客在车上的区间是 [trip[1], trip[2] - 1]
            int val = trip[0];
            int i = trip[1];
            int j = trip[2] - 1;
            diff[i] += val;
            if (j + 1 < nums.length) {
                diff[j + 1] -= val;
            }
        }

        int[] res = new int[nums.length];
        res[0] = diff[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        for (int re : res) {
            if (capacity < re) {
                return false;
            }
        }
        return true;
    }
}
