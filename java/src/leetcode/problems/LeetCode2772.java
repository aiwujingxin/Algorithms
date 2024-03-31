package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/30 15:11
 */
public class LeetCode2772 {

    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] d = new int[n + 1];
        d[0] = nums[0];
        for (int i = 1; i < n; i++) {
            d[i] = nums[i] - nums[i - 1];
        }
        for (int i = 0; i + k <= n; i++) {
            if (d[i] > 0) {
                d[i + k] += d[i];
                d[i] = 0;
            } else if (d[i] < 0) {
                return false;
            }
        }
        // 检查差分数组中不能进行区间修改的元素是否均为 0
        for (int i = n - k + 1; i < n; i++) {
            if (d[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
