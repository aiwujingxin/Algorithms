package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 22:31
 * @link <a href="https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/solution/bao-han-suo-you-san-chong-zi-fu-de-zi-zi-fu-chuan-/">...</a>
 */
public class LeetCode1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        return getSubArr(nums, k) - getSubArr(nums, k - 1);
    }

    private int getSubArr(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int res = 0;
        while (right < n) {
            cnt += (nums[right] & 1);
            while (cnt > k) {
                cnt -= (nums[left] & 1);
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
