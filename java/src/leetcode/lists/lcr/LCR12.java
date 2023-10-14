package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 14:44
 */
public class LCR12 {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            if (t * 2 + nums[i] == sum) {
                return i;
            }
            t += nums[i];
        }
        return -1;
    }
}
