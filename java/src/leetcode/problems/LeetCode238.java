package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 14:45
 */
public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        int[] res = new int[n];
        int t = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = prefix[i] * t;
            t = t * nums[i];
        }
        return res;
    }
}
