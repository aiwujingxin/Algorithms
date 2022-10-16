package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 18:38
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
            int mx = max;
            int mn = min;
            max = Math.max(mn * nums[i], Math.max(mx * nums[i], nums[i]));
            min = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }
}
