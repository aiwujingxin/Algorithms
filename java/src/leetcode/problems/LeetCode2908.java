package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 1/5/26 23:25
 */
public class LeetCode2908 {

    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = nums[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.min(l[i - 1], nums[i]);
        }
        r[n - 1] = nums[n - 1];
        for (int i = n - 2; i < n; i++) {
            r[i] = Math.min(r[i + 1], nums[i]);
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if (l[i - 1] < nums[i] && r[i + 1] < nums[i]) {
                sum = Math.min(sum, nums[i] + l[i - 1] + r[i + 1]);
            }
        }
        return sum;
    }
}
