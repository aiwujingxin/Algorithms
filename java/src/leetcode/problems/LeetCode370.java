package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/24 18:17
 */
public class LeetCode370 {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for (int[] update : updates) {
            diff[update[0]] += update[2];
            if (update[1] + 1 < diff.length) {
                diff[update[1] + 1] -= update[2];
            }
        }
        int[] nums = new int[length];
        nums[0] = diff[0];
        for (int i = 1; i < length; i++) {
            nums[i] = nums[i - 1] + diff[i];
        }
        return nums;
    }
}
