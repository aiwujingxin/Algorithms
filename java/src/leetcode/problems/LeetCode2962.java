package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 10/10/25 11:21
 * @description 转换窗口条件
 */
public class LeetCode2962 {
    public long countSubarrays(int[] nums, int k) {
        long n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int cnt = 0;
        int l = 0;
        int r = 0;
        long t = 0;
        long total = n * (n + 1) / 2;
        while (r < n) {
            if (nums[r] == max)
                cnt++;
            while (l < r && cnt > k - 1) {
                if (nums[l] == max)
                    cnt--;
                l++;
            }
            if (cnt <= k - 1) {
                t += r - l + 1;
            }
            r++;
        }
        return total - t;
    }
}
