package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 21:24
 * @description 观察
 * @link <a href="https://www.youtube.com/watch?v=xFlO0H1l2oQ"></a>
 */
public class LeetCode798 {

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] <= i) {
                diff[0] += 1;
                diff[i - nums[i] + 1] -= 1;
                diff[i + 1] += 1;
            } else {
                diff[0] += 0;
                diff[i + 1] += 1;
                diff[i + 1 + n - nums[i]] -= 1;
            }
        }
        int sum = 0;
        int max = 0;
        int k = 0;
        for (int i = 1; i < n; i++) {
            sum += diff[i];
            if (sum > max) {
                max = sum;
                k = i;
            }
        }
        return k;
    }
}
