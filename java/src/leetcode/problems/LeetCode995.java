package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/8/25 19:06
 * @description 差分优化
 * @link <a href="https://leetcode.cn/problems/minimum-number-of-k-consecutive-bit-flips/"></a>
 */
public class LeetCode995 {

    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] arr = new int[n + 1];
        for (int i = 0, cnt = 0; i < n; i++) {
            cnt += arr[i];
            if ((nums[i] + cnt) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }
                arr[i + 1]++;
                arr[i + k]--;
                ans++;
            }
        }
        return ans;
    }
}
