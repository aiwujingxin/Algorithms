package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 14:23
 * <a href="https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/xiao-er-me-c304e/">...</a>
 */
public class LeetCode1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        // 最多有 1001 个车站
        int[] nums = new int[1001];
        // 构造差分解法
        int[] diff = new int[nums.length];
        for (int[] trip : trips) {
            // 乘客数量
            int val = trip[0];
            // 第 trip[1] 站乘客上车
            int i = trip[1];
            // 第 trip[2] 站乘客已经下车，
            // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            // 进行区间操作
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
        // 客车自始至终都不应该超载
        for (int re : res) {
            if (capacity < re) {
                return false;
            }
        }
        return true;
    }
}
