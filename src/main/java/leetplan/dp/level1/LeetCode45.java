package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 21:53
 */

public class LeetCode45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int curMax = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == curMax) {
                count++;
                curMax = max;
            }
        }
        return count;
    }
}
