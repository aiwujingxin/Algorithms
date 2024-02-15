package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/8 12:41
 */
public class LeetCode1829 {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ nums[i];
        }
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[n - i - 1] = cal(pre[i], maximumBit);
        }
        return ans;
    }

    private int cal(int num, int maximumBit) {
        int res = 0;
        for (int i = 0; i < maximumBit; i++) {
            if ((num & 1) == 1) {
                res |= 0;
            } else {
                res |= 1 << i;
            }
            num >>= 1;
        }
        return res;
    }
}
