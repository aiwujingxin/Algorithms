package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/31 23:45
 */
public class LeetCode1004_sd {

    //https://leetcode.cn/problems/max-consecutive-ones-iii/solution/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/
    public int longestOnes(int[] nums, int K) {
        int N = nums.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < N) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > K) {
                if (nums[left++] == 0) {
                    zeros--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
