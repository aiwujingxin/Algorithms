package leetcode.hot200;

/**
 * @author jingxinwu
 * @date 2022-03-08 2:11 PM
 */
public class LeetCode280 {

    /**
     * 给你一个的整数数组nums, 将该数组重新排序后使nums[0] <= nums[1] >= nums[2] <= nums[3]...
     * 输入数组总是有一个有效的答案。
     * 示例 1:
     * 输入：nums = [3,5,2,1,6,4]
     * 输出：[3,5,1,6,2,4]
     * 解释：[1,6,2,5,3,4]也是有效的答案
     * <p>
     * 示例 2:
     * 输入：nums = [6,6,5,6,3,8]
     * 输出：[6,6,5,6,3,8]
     **/
    // unknown
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
