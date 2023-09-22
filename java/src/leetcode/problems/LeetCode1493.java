package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/20 21:01
 */
public class LeetCode1493 {


    public int longestSubarray(int[] nums) {
        int n = nums.length, res = 0, cnt = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] == 0) {
                cnt++;
            }
            while (cnt > 1) {
                if (nums[j] == 0) {
                    cnt--;
                }
                j++;
            }
            res = Math.max(res, i - j);
        }
        return res;
    }
}
