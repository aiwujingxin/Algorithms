package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 02:26
 */
public class LeetCode152 {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mi = min, mx = max;
            max = Math.max(Math.max(mi * nums[i], mx * nums[i]), nums[i]);
            min = Math.min(Math.min(mi * nums[i], mx * nums[i]), nums[i]);
            res = Math.max(Math.max(max, min), res);
        }
        return res;
    }
}
