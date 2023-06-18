package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:41
 */
public class LeetCode992_sd {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] num1 = new int[n + 1];
        int[] num2 = new int[n + 1];
        int tot1 = 0, tot2 = 0;
        int left1 = 0, left2 = 0, right = 0;
        int ret = 0;
        while (right < n) {
            if (num1[nums[right]] == 0) {
                tot1++;
            }
            num1[nums[right]]++;
            if (num2[nums[right]] == 0) {
                tot2++;
            }
            num2[nums[right]]++;
            while (tot1 > k) {
                num1[nums[left1]]--;
                if (num1[nums[left1]] == 0) {
                    tot1--;
                }
                left1++;
            }
            while (tot2 > k - 1) {
                num2[nums[left2]]--;
                if (num2[nums[left2]] == 0) {
                    tot2--;
                }
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }
}
