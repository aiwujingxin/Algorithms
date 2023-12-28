package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/28 16:05
 */
public class LeetCode260 {

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            t = t ^ nums[i];
        }
        int flag = t & (-t);
        int index;
        for (index = 0; index < 32; index++) {
            if (1 << index == flag) {
                break;
            }
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((((num >> index) & 1) == 1)) {
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }
        return new int[]{a, b};
    }
}
