package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-17 12:51 PM
 */
public class LeetCode152 {


    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max;
            int mn = min;
            max = Math.max(nums[i], Math.max(nums[i] * mx, nums[i] * mn));
            min = Math.min(nums[i], Math.min(nums[i] * mx, nums[i] * mn));
        }
        return max;

    }
}
